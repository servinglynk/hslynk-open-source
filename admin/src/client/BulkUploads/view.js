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

import { getBulkUploads, deleteProjectGroup } from '../../config/actions/BulkUploads'
import  Datatable  from './Datatable';
import  Breadcrumb  from '../../layout-components/Breadcrumb';

const BulkUploadActivity = (props) => {
  const [bulkUploads,setBulkUploads] = useState([]);
  const [Alert,setAlert] = useState(false);
  const [bulkUploadId,setBulkUploadId] = useState('');
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  
  useEffect(() => {
    getBreadCrumbItems();
      const params = {
        startIndex : 0,
        maxItems : 10
      };

      props.getBulkUploads('/bulk-upload?status=RECENT',{},params,'get').then((response) => {
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
    maxWidth:'30%',
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
  },{
    name: 'Username',
    selector: 'username',
    sortable: true,
    right: true,
    maxWidth:'10%',
    center:true
  },{
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
      console.log(row);
      return (
        <>
        <a
          className="coinName pl-2"
          href={'/BulkUploads/' + row.projectGroupId }
          rel="noopener noreferrer">
          <span className="sub ">
             Logs
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
              href="/BulkUploads/create"
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
      <ToastContainer />
    </Fragment>
  );
}

const mapStateToProps = state => ({
   data: state.BulkUploads.data,
   pagination: state.BulkUploads.pagination,
})
export default connect(mapStateToProps,{BulkUploadActivity})(withRouter(ProjectGroup));

