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

import { PageTitle } from '../../layout-components';
import { ExampleWrapperSeamless } from '../../layout-components';
import { getUsers, deleteUser } from '../../config/actions/Users';
import  Datatable  from './Datatable';
import  Breadcrumb  from '../../layout-components/Breadcrumb'

const Users = (props) => {
  const [users,setUsers] = useState([{id:1,skipuseridentifers:true}]);
  const [Alert,setAlert] = useState(false);
  const [userId,setUserId] = useState('');
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  
 useEffect(() => {
  //getBreadCrumbItems();
  const params = {
    startIndex : 0,
    maxItems : 10
  };
  props.getUsers('/accounts',{},params,'get').then((response) => {
    console.log("response",response);
    // setUsers(response.accounts.account);
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
  setUserId(id);
  setAlert(true);
}

const confirmDelete = () => {
  setAlert(false);
  props.deleteUser('/accounts/'+userId,{},{},'delete').then((response) => {
    if(response.status==200){
      toast.success("User deleted successfully")
      const params = {
        startIndex : 0,
        maxItems : 10
      };
      props.getUsers('/accounts',{},params,'get');
    }
  }).catch((ex) => {
    console.log('error', ex);
  })
}

const cancelDelete = () =>{
  console.log("cancel");
  setAlert(false);
}

const columns = [
  {
    name: 'First Name',
    selector: 'firstName',
    sortable: true,
    maxWidth:'20%',
    center:true,
    textWeight:600,
    cell: row => {
      return (
        <>
        <a
          className="coinName info-color"
          href={'/Users/' + row.accountId}
          rel="noopener noreferrer">
          <span className="sub ">
            {row.firstName}
          </span>
        </a>
        </>
      );
    },  
  },
  {
    name: 'Last Name',
    selector: 'lastName',
    sortable: true,
    right: true,
    maxWidth:'30%',
    center:true
  },
  {
    name: 'Username',
    selector: 'username',
    sortable: true,
    right: true,
    maxWidth:'30%',
    center:true
  },
  {
    name: 'Status',
    selector: 'status',
    sortable: true,
    right: true,
    maxWidth:'30%',
    center:true
  },
  ,{
    name: 'Action',
    selector: 'key',
    sortable: false,
    width: '20%',
    cell: row => {
      return (
        <>
        <a
          className="coinName ml-2 btn-normal btn btn-secondary btn btn-secondary btn btn-secondary"  
          href={'/Users/' + row.accountId + '/edit'}
          rel="noopener noreferrer">
          <span className="sub ">
            Edit
          </span>
        </a>
        <a href=""
          className="coinName ml-2 btn-danger btn btn-secondary btn btn-secondary"
          onClick={()=>deleteRow(row.accountId)}
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
      <Breadcrumb  data={breadcrumbItems} showVersion={true} current="users" />
      <Card className="card-box mb-5">
        <div className="card-header">
          <div className="card-header--title">
            <h3>Users</h3>
          </div>
          <div className="card-header--actions">
            <Button
              tag="a"
              href="/Users/create"
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
  data: state.Users.data,
  pagination: state.Users.pagination,
})
export default connect(mapStateToProps,{getUsers, deleteUser})(withRouter(Users));

