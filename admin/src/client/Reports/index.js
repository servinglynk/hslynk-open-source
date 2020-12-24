import React, { Fragment, useEffect, useState } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  CardBody,
  Card,
  Button,
  Modal,ModalHeader,ModalBody,ModalFooter,Table
} from 'reactstrap';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
import { ToastContainer, toast } from 'react-toastify';
import { getReports, downloadFile,getSelectedProjectList } from '../../config/actions/Reports'
import  Datatable  from './Datatable';
import  Breadcrumb  from '../../layout-components/Breadcrumb';
import  Spinner  from '../../layout-components/Spinner';

const Reports = (props) => {
  const [reports,setReports] = useState([]);
  const [Alert,setAlert] = useState(false);
  const [reportId,setReportId] = useState('');
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  const [modal, setModal] = useState(false); 
  const selectedProjectList = [];
  console.log("selectedProjectList",selectedProjectList);
  const [selectedProject,setSelectedProject] = useState([])
  const [spinner, setSpinner] = useState(false);

  const toggle = async () => setModal(!modal);

  useEffect(() => {
    getBreadCrumbItems();
   
      const params = {
        startIndex : 0,
        maxItems : 10
      };

      props.getReports('/reports',{},params,'get').then((response) => {
        console.log("response",response);
      }).catch((ex) => {
        console.log('error', ex);
      })
 }, [selectedProject]);

const getBreadCrumbItems = () => {
    var paths = window.location.pathname.split("/")
    var url = window.location.pathname;
    const urls = []
    paths.forEach(() => {
        url = url.substring(0, url.lastIndexOf('/'))
        if (url !== ""){
            if(url == '/admin') {
              url = '/dashboard';
            }
            urls.push({ link: url, name: url.split("/").pop() })
          }
    })
    setBreadcrumbItems(urls.reverse());
  }

  const GetProjectList = (projectIdArray) => {
    projectIdArray.forEach(async ProjectID => {
      props.getSelectedProjectList(`v2020/v2/projects/${ProjectID.projectId}`,{},{},'get').then((response) => {
        console.log("response",response.payload);
        let obj ={};
        obj['projectId'] = response.payload.projectId;
        obj['projectName'] = response.payload.projectName;
        selectedProjectList.push(obj)
        setSelectedProject(selectedProjectList)
      }).catch((ex) => {
        console.log('error', ex);
      })
    })
    toggle()
  }

  const downloadHMISFile = (objectID)  => {
    setSpinner(true);
    props.downloadFile(objectID, null, 'reports').then(res => {
      const url = window.URL.createObjectURL(new Blob([res.data],{type: "application/zip", 'responseType': 'arraybuffer' }));
      const link = document.createElement('a');
      link.href = url;
      link.setAttribute('download', objectID+'.zip');
      document.body.appendChild(link);
      link.click();
       if (res && res && res.status === 200) {
          setSpinner(false);
          toast.success("Successfully Downloaded !");
          props.history.push('/Reports');
       }
    })
  }


const columns = [
  {
    name: 'Name',
    selector: 'name',
    sortable: true,
    maxWidth:'20%',
    center:true,
  },
  {
    name: 'Start Date',
    selector: 'startDate',
    sortable: true,
    right: true,
    maxWidth:'30%',
    center:true
  },
  {
    name: 'End Date',
    selector: 'endDate',
    sortable: true,
    right: true,
    maxWidth:'20%',
    center:true
  }, {
    name: 'Type',
    selector: 'reportType',
    sortable: true,
    right: true,
    maxWidth:'10%',
    center:true
  },{
    name: 'Action',
    selector: 'key',
    sortable: false,
    width: '20%',
    center:true,
    cell: row => {
      return (
        <>
        <Button className="btn-normal btn btn-secondary btn btn-secondary"  onClick={()=>downloadHMISFile(row.id)}>Download</Button>
        <Button className="ml-2 btn-danger btn btn-secondary" onClick={() => GetProjectList(row.projectIds)}>Projects</Button>
        {/* <a
          className="coinName pl-2"
          rel="noopener noreferrer"
          onClick={()=>downloadHMISFile(row.id)}
          >
          <span className="sub ">
            <span className="pe-7s-angle-down-circle info-color"></span>
          </span>
        </a> */}
        </>
      );
    },
  },
];

  return (
    <Fragment>
      <Breadcrumb  data={breadcrumbItems} showVersion={true} current="reports" />
      <Card className="card-box mb-5">
        <div className="card-header">
          <div className="card-header--title">
            <h3>Reports</h3>
          </div>
          <div className="card-header--actions">
            <Button
              tag="a"
              href="/Reports/create"
              size="sm"
              className="text-default btn-normal"
              title="View details">
              <span className="btn-wrapper--label">Add New</span>
            </Button>
          </div>
        </div>
        <CardBody className="p-0">
            <div className="table-responsive-md table-title report-datatable">
              { spinner ?
                <Spinner loading= {spinner}/>
              :
                <Datatable 
                  columns = {columns}
                />
              }
            </div>
           
        </CardBody>
      </Card>

      <Modal isOpen={modal} toggle={toggle} centered >
        <ModalHeader toggle={toggle}>Project List</ModalHeader>
        <ModalBody className="log-table table-responsive">
          <Table size="md"> 
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Name</th>
                </tr>
              </thead>
              <tbody>
                {selectedProject.map((data,i) => 
                    <tr key={i}>
                      <th>{data.projectId}</th>
                      <td>{data.projectName}</td>
                    </tr>
                )}
              
              </tbody>
          </Table>
        </ModalBody>
        <ModalFooter>
          <Button color="warning" onClick={toggle}>Close</Button>
        </ModalFooter>
      </Modal>
      <ToastContainer />
    </Fragment>
  );
}

const mapStateToProps = state => ({
   data: state.Reports.data,
   selectedProject: state.Reports.selectedProject,
   pagination: state.Reports.pagination,
})
export default connect(mapStateToProps,{getReports, downloadFile,getSelectedProjectList})(withRouter(Reports));

