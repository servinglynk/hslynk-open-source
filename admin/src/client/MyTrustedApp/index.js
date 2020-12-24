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
import { ToastContainer, toast } from 'react-toastify';
import { getTrustedAppProjectGroups } from '../../config/actions/TrustedApps';
import  Datatable  from './Datatable';
import  Breadcrumb  from '../../layout-components/Breadcrumb'
import config from "../../data/config"; 

const Trustedprojectgroups = (props) => {
  const [myTrustedApp,setMyTrustedApp] = useState([]);
  const [Alert,setAlert] = useState(false);
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  
 useEffect(() => {
  //getBreadCrumbItems();
  const params = {
    startIndex : 0,
    maxItems : 10
  };
  const projectGroupId = localStorage.getItem('projectGroupId');
  props.getTrustedAppProjectGroups('/projectgroups/'+projectGroupId+'/trustedapps',{},params,'get').then((response) => {
    console.log("response",response);
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

  const columns = [
    {
      name: 'Trusted App Name',
      selector: 'friendlyName',
      sortable: true,
      maxWidth:'20%',
      center:true 
    },
    {
      name: 'Description',
      selector: 'description',
      sortable: true,
      right: true,
      maxWidth:'30%',
      center:true
    },
    {
      name: 'Profile Type',
      selector: 'trustedAppProfileType',
      sortable: true,
      right: true,
      maxWidth:'20%',
      center:true
    }, {
      name: 'Status',
      selector: 'status',
      sortable: true,
      right: true,
      maxWidth:'10%',
      center:true
    }
  ];

  return (
    <Fragment>
      <Breadcrumb  data={breadcrumbItems} showVersion={true} current="trustedApps" />
      <Card className="card-box mb-5">
      <div className="card-header">
          <div className="card-header--title">
  <h3>My Project Group : { JSON.parse(localStorage.getItem('loggedInUserData')).projectGroup.projectGroupName}</h3>
          </div>
          <div className="card-header--actions">
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
      <ToastContainer />
    </Fragment>
  );
}

const mapStateToProps = state => ({
  data: state.MyTrustedApp.data,
  pagination: state.MyTrustedApp.pagination,
})
export default connect(mapStateToProps,{getTrustedAppProjectGroups})(withRouter(Trustedprojectgroups));

