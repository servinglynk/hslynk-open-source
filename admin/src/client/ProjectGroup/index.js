import React, { Fragment, useEffect, useState } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  CardBody,
  Card,
  CardHeader, 
  Button,
  Badge
} from 'reactstrap';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
import SweetAlert from 'react-bootstrap-sweetalert';
import { ToastContainer, toast } from 'react-toastify';

import { getProjectGroups, deleteProjectGroup } from '../../config/actions/Projectgroup'
import  Datatable  from './Datatable';
import  Breadcrumb  from '../../layout-components/Breadcrumb';

const ProjectGroup = (props) => {
  const [projectGroups,setProjectGroups] = useState([]);
  const [Alert,setAlert] = useState(false);
  const [projectGroupId,setProjectGroupId] = useState('');
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  
  useEffect(() => {
    getBreadCrumbItems();
      const params = {
        startIndex : 0,
        maxItems : 10
      };

      props.getProjectGroups('/projectgroups',{},params,'get').then((response) => {
        console.log("response",response);
        // setProjectGroups(response.data.projectgroups.projectGroups);
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
const deleteRow = (id) =>{
  setProjectGroupId(id);
  setAlert(true);
}

const confirmDelete = () => {
  setAlert(false);
  props.deleteProjectGroup('/projectgroups/'+projectGroupId,{},{},'delete').then((response) => {
    if(response.status==200){
      toast.success("ProjectGroup deleted successfully")
      const params = {
        startIndex : 0,
        maxItems : 10
      };
      props.getProjectGroups('/projectgroups',{},params,'get');
    }
  }).catch((ex) => {
    console.log('error', ex);
  })
}

const cancelDelete = () =>{
  setAlert(false);
}

const columns = [
  {
    name: 'Project Group Name',
    selector: 'projectGroupName',
    sortable: true,
    maxWidth:'20%',
    center:true,
    cell: row => {
      return (
        <>
        <a
          className="coinName info-color"
          href={'/ProjectGroups/' + row.projectGroupId}
          rel="noopener noreferrer">
          <span className="sub ">
            {row.projectGroupName}
          </span>
        </a>
        </>
      );
    },  
  },
  {
    name: 'Project Group Desc',
    selector: 'projectGroupDesc',
    sortable: true,
    right: true,
    maxWidth:'30%',
    center:true
  },
  {
    name: 'Project Group Code',
    selector: 'projectGroupCode',
    sortable: true,
    right: true,
    maxWidth:'20%',
    center:true
  }, {
    name: 'Skip User Identifers',
    selector: 'skipuseridentifers',
    sortable: true,
    right: true,
    maxWidth:'10%',
    center:true
  },{
    name: 'Action',
    selector: 'key',
    sortable: false,
    width: '20%',
    cell: row => {
      return (
        <>
        <a
          className="coinName btn-normal btn btn-secondary"
          href={'/ProjectGroups/' + row.projectGroupId + '/edit'}
          rel="noopener noreferrer">
          <span className="sub ">
            Edit
          </span>
        </a>
        <a
          className="coinName ml-2 btn btn-danger"
          onClick={()=>deleteRow(row.projectGroupId)}
          rel="noopener noreferrer">
          <span className="sub">
            Delete
          </span>
        </a>
        </>
      );
    },
  },
];


  return (
    <Fragment>
      <Breadcrumb  data={breadcrumbItems} showVersion={true} current="projectGroups" />
      <Card className="card-box mb-5">
        <div className="card-header">
          <div className="card-header--title">
            <h3>Project Groups</h3>
          </div>
          <div className="card-header--actions">
            <Button
              tag="a"
              href="/ProjectGroups/create"
              size="sm"
              className="text-default btn-normal"
              title="View details">
              <span className="btn-wrapper--label">Add New</span>
            </Button>
          </div>
        </div>
        <CardBody className="p-0">
          
            <div className="table-responsive-md table-title">
              <Datatable 
                columns = {columns}
              />
            </div>
           
        </CardBody>
      </Card>
      <SweetAlert
        warning
        showCancel
        show={Alert}
        confirmBtnText="Yes, delete it!"
        confirmBtnBsStyle="danger"
        title="Are you sure?"
        onConfirm={()=>confirmDelete()}
        onCancel={()=>cancelDelete()}
        focusCancelBtn
      >
        You will not be able to recover this imaginary file!
      </SweetAlert>
      <ToastContainer />
    </Fragment>
  );
}

const mapStateToProps = state => ({
   data: state.Projectgroup.data,
   pagination: state.Projectgroup.pagination,
})
export default connect(mapStateToProps,{getProjectGroups, deleteProjectGroup})(withRouter(ProjectGroup));

