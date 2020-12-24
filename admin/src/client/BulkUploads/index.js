import React, { Fragment, useEffect, useState } from 'react';
import {CardBody,Card,Button,TabContent,TabPane,Nav,NavItem,NavLink,Modal, ModalHeader, ModalBody, ModalFooter,InputGroup, InputGroupText, InputGroupAddon,Input} from 'reactstrap';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
import { ToastContainer, toast } from 'react-toastify';
import { getBulkUploads,getActiveLogBulkUploads,getErrorsBulkUploads } from '../../config/actions/BulkUploads'
import  Datatable  from './Datatable';
import  Breadcrumb  from '../../layout-components/Breadcrumb';
import Table from 'reactstrap/lib/Table';
import  Spinner  from '../../layout-components/Spinner';

const UploadList = (props) => {
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  const [activeTab,setActiveTab] = useState("recent")
  const [modal, setModal] = useState(false); 
  const [spinner, setSpinner] = useState(false);
  const [data,setData] = useState([])
  console.log(data);
  const toggle = () => setModal(!modal);
  console.log(props.data);
  useEffect(() => {
    if(props.data){
      setSpinner(false);
    } else{
      setSpinner(true);
    }
    getBreadCrumbItems();
      const params = {
        startIndex : 0,
        maxItems : 30
      };
      props.getBulkUploads('/bulk-upload?status=RECENT',{},params,'get').then((response) => {
        console.log("response",response);
        setData(response.payload.bulkUploads)
      }).catch((ex) => {
        console.log('error', ex);
      })
 }, []);

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

  const GetActiveLog = (id,year) => {
    toggle()
    const params = {
      startIndex : 0,
      maxItems : 10
    };
    props.getActiveLogBulkUploads(`/hmis-clientapi-v${year}/rest/bulkupload/activities/${id}`,{},params,'get').then((response) => {
      console.log("response",response);
    }).catch((ex) => {
      console.log('error', ex);
    })
  }

  const GetErrors = (id,year) => {
    localStorage.setItem("id",id)
    localStorage.setItem("year",year)
    console.log(id,year);
    const params = {
      startIndex : 0,
      maxItems : 10
    };
      props.getErrorsBulkUploads(`/hmis-clientapi-v${year}/rest/bulkupload/errors/${id}`,{},params,'get').then((response) => {
      console.log("response",response);
      props.history.push(`/BulkUploads/errorMessage/${id+"-"+year}`, {state : { id,year }})
      
    }).catch((ex) => {
      console.log('error', ex);
    })
  }
  
const columns = [
  {
    name: 'Id',
    selector: 'id',
    sortable: true,
    maxWidth:'20%',
    center:true,
    cell: row => {
    return (
      <>
      <a
        className="coinName info-color"
        href={'/BulkUploads/' + row.id+"-"+row.year}
        rel="noopener noreferrer">
        <span className="sub ">
          {row.id}
        </span>
      </a>
      </>
    );
  }, 
  },
  {
    name: 'File Name',
    selector: 'fileName',
    sortable: true,
    right: true,
    maxWidth:'20%',
    center:true
  },
  {
    name: 'Status',
    selector: 'status',
    sortable: true,
    right: true,
    maxWidth:'20%',
    center:true
  }, {
    name: 'Year',
    selector: 'year',
    sortable: true,
    right: true,
    maxWidth:'10%',
    center:true
  },{
    name: 'HUD Version',
    selector: 'hudVersion',
    sortable: true,
    right: true,
    maxWidth:'10%',
    center:true
  },
  {
    name: 'Username',
    selector: 'username',
    sortable: true,
    right: true,
    maxWidth:'0%',
    center:true
  },
  {
    name: 'Date Created',
    selector: 'dateCreated',
    sortable: true,
    right: true,
    maxWidth:'10%',
    center:true
  },{
    name: 'Description',
    selector: 'description',
    sortable: true,
    right: true,
    maxWidth:'10%',
    center:true
  }
  ,{
    name: 'Action',
    selector: 'key',
    sortable: false,
    width: '20%',
    cell: row => {
      return (
        <>
        <Button className="coinName btn-normal btn btn-secondary" onClick={() => GetActiveLog(row.id,row.year)} >Logs</Button>
        <Button className="coinName ml-2 btn btn-danger" onClick={() => GetErrors(row.id,row.year)}>Error</Button>
         </>
      );
    },
  },
];


  return (
    <Fragment>
      <Breadcrumb  data={breadcrumbItems} showVersion={true} current="BulkUpload" />
      <Card className="card-box mb-5">
        <div className="card-header">
          <div className="card-header--title">
            <h3>HMIS Uploads</h3>
          </div>
          <div className="card-header--actions">
            <Button
              tag="a"
              href="/BulkUploads/create"
              size="sm"
              className="text-default btn-normal"
              title="View details">
              <span className="btn-wrapper--label">Add New</span>
            </Button>
          </div>
        </div>
        <Nav tabs className="m-2"> 
              <NavItem><NavLink className={activeTab === "recent" ? 'active' : ''} onClick={() => setActiveTab("recent")}>Recent</NavLink></NavItem>
              <NavItem><NavLink className={activeTab === "all" ? 'active' : ''}onClick={() => setActiveTab("all")}>All Upload</NavLink></NavItem>
        </Nav>
        <CardBody className="p-0">
            <TabContent activeTab={activeTab}>
              <TabPane tabId="recent">
              { spinner ?
              <Spinner loading= {spinner}/>
              :
              <>
              <InputGroup className="pt-2 pl-2 w-50 m-2" size="md">
                  <InputGroupAddon addonType="prepend">
                    <InputGroupText><span className="pe-7s-search"></span></InputGroupText>
                  </InputGroupAddon>
                  <Input  type="text" name="search" placeholder="Search..." />
              </InputGroup>
              <div className="table-responsive-md table-title m-2">
                <h3 >Recent Upload</h3>
                <Table size="md"> 
                    <thead>
                      <tr>
                        <th>Id</th>
                        <th>File Name</th>
                        <th>Status</th>
                        <th>HUD Version</th>
                        <th>UserName</th>
                        <th>Date Created</th>
                        <th>Description</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      {data.slice(0,6).map((list,i) => {
                        return(
                        <tr key={i}>
                          <th scope="row">{list.id}</th>
                          <td>{list.fileName}</td>
                          <td>{list.status}</td>
                          <td>{list.hudVersion}</td>
                          <td>{''}</td>
                          <td>{list.dateCreated}</td>
                          <td>{''}</td>
                          <td colSpan="2">
                            <span>
                              <Button className="btn-normal btn btn-secondary" onClick={() => GetActiveLog(list.id,list.year)}>Log</Button>
                              <Button className="ml-2 btn btn-danger" onClick={() => GetErrors(list.id,list.year)}>Error</Button>
                            </span>
                          </td>
                        </tr>
                        )
                      })}
                    </tbody>
                  </Table>
              </div>
              </>
              }
              </TabPane>
              <TabPane tabId="all">
              <div className="table-responsive-md table-title">
                <Datatable 
                  columns = {columns}
                />
              </div>
              </TabPane>
            </TabContent>
        </CardBody>
      </Card>
      <Modal isOpen={modal} toggle={toggle} centered >
        <ModalHeader toggle={toggle}>Sync File Log</ModalHeader>
        <ModalBody className="log-table table-responsive">
          <Table size="md"> 
              <thead>
                <tr>
                  <th>Table Names</th>
                  <th>Records</th>
                  <th>Inserted</th>
                  <th>Updated</th>
                </tr>
              </thead>
              <tbody>
                {props.logData.map((data,i) => {
                  return(
                    <tr key={i}>
                      <th>{data.tableName}</th>
                      <td>{data.recordsProcessed}</td>
                      <td>{data.inserted}</td>
                      <td>{data.updated}</td>
                    </tr>
                  )
                })}
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
   data: state.BulkUploads.data,
   logData: state.BulkUploads.log,
   pagination: state.BulkUploads.pagination,
})

export default connect(mapStateToProps,{getBulkUploads,getActiveLogBulkUploads,getErrorsBulkUploads})(withRouter(UploadList));

