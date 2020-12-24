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
import { getTrustedApps } from '../../config/actions/TrustedApps';
import  Datatable  from './Datatable';
import  Breadcrumb  from '../../layout-components/Breadcrumb'

const TrustedApps = (props) => {
  const [trustedApps,setTrustedApps] = useState([]);
  const [Alert,setAlert] = useState(false);
  const [trustedAppId,setTrustedAppId] = useState('');
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  
 useEffect(() => {
  getBreadCrumbItems();
  const params = {
    startIndex : 0,
    maxItems : 10
  };
  props.getTrustedApps('/trustedapps',{},params,'get').then((response) => {
    console.log("response",response);
    localStorage.setItem('trustedApps',JSON.stringify(response.payload.trustedApp));
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

const columns = [
  {
    name: 'Name',
    selector: 'friendlyName',
    sortable: true,
    maxWidth:'20%',
    center:true,
    textWeight:600,
    cell: row => {
      return (
        <>
        <a
          className="coinName info-color"
          href={'/TrustedApps/' + row.trustedAppId+'/edit'}
          rel="noopener noreferrer">
          <span className="sub ">
            {row.friendlyName}
          </span>
        </a>
        </>
      );
    },  
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
    name: 'Status',
    selector: 'status',
    sortable: true,
    right: true,
    maxWidth:'20%',
    center:true
  }, {
    name: 'Type',
    selector: 'trustedAppProfileType',
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
          href={'/TrustedApps/' + row.trustedAppId + '/edit'}
          rel="noopener noreferrer">
          <span className="sub ">
           Edit
          </span>
        </a>
        </>
      );
    },
  },
];

  return (
    <Fragment>
      <Breadcrumb  data={breadcrumbItems} showVersion={true} current="trustedApps" />
      <Card className="card-box mb-5">
      <div className="card-header">
          <div className="card-header--title">
            <h3>Trusted Apps</h3>
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
  data: state.TrustedApps.data,
  pagination: state.TrustedApps.pagination,
})
export default connect(mapStateToProps,{getTrustedApps})(withRouter(TrustedApps));

