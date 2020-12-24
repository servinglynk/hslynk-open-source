import React, { Fragment, Component, useEffect, useState } from 'react';

import PerfectScrollbar from 'react-perfect-scrollbar';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
import RouterLink from '../ReactMetismenuRouterLink';

import MetisMenu from 'react-metismenu';
import { getLoggedInUserDetails, logOut } from '../../config/actions/Auth'


const sidebarMenuContentNormal = [
  {
    label: 'Dashboards',
    icon: 'pe-7s-safe',
    description:
      'These can be used with other components and elements to create stunning and unique new elements for your UIs.',
    to: '/dashboard'
  },
  {
    label: 'Users',
    icon: 'pe-7s-add-user',
    description:
          'Wide selection of cards with multiple styles, borders, actions and hover effects.',
    to: '/Users'
  },
  // {
  //   label: 'My Trusted App',
  //   icon: 'pe-7s-help2',
  //   description:
  //         'Wide selection of cards with multiple styles, borders, actions and hover effects.',
  //   to: '/MyTrustedApp'
  // },
  {
    label: 'Bulk Upload',
    icon: 'pe-7s-cloud-upload',
    description:
          'Wide selection of cards with multiple styles, borders, actions and hover effects.',
    to: '/BulkUploads'
  },
  {
    label: 'Export',
    icon: 'pe-7s-cloud-download',
    description:
          'Wide selection of cards with multiple styles, borders, actions and hover effects.',
    to: '/Exports'
  },
  {
    label: 'Reports',
    icon: 'pe-7s-target',
    description:
          'Wide selection of cards with multiple styles, borders, actions and hover effects.',
    to: '/Reports'
  }
];
const sidebarMenuContentAdmin = [
  {
    label: 'Dashboards',
    icon: 'pe-7s-safe',
    description:
      'These can be used with other components and elements to create stunning and unique new elements for your UIs.',
    to: '/dashboard'
  },
  {
    label: 'Project Group',
    icon: 'pe-7s-box2',
    description:
          'Wide selection of cards with multiple styles, borders, actions and hover effects.',
    to: '/ProjectGroups'
  },
  {
    label: 'Users',
    icon: 'pe-7s-add-user',
    description:
          'Wide selection of cards with multiple styles, borders, actions and hover effects.',
    to: '/Users'
  },
  {
    label: 'My Trusted App',
    icon: 'pe-7s-help2',
    description:
          'Wide selection of cards with multiple styles, borders, actions and hover effects.',
    to: '/MyTrustedApp'
  },
  {
    label: 'Trusted App',
    icon: 'pe-7s-help2',
    description:
          'Wide selection of cards with multiple styles, borders, actions and hover effects.',
    to: '/TrustedApps'
  },
  {
    label: 'Bulk Upload',
    icon: 'pe-7s-cloud-upload',
    description:
          'Wide selection of cards with multiple styles, borders, actions and hover effects.',
    to: '/BulkUploads'
  },
  {
    label: 'Export',
    icon: 'pe-7s-cloud-download',
    description:
          'Wide selection of cards with multiple styles, borders, actions and hover effects.',
    to: '/Exports'
  },
  {
    label: 'Reports',
    icon: 'pe-7s-target',
    description:
          'Wide selection of cards with multiple styles, borders, actions and hover effects.',
    to: '/Reports'
  }
];

const SidebarMenu = (props) => {
  const [sidebarMenuContent,setSidebarMenuContent]= useState([]);
  useEffect(() => {
    setSidebarMenuContent(sidebarMenuContentAdmin)
    if(localStorage.getItem('role')=='null' || localStorage.getItem('role')==null){
      props.getLoggedInUserDetails('/accounts/self/basicinfo').then((res) => {
        console.log(res);
        let role = res.payload.data.account.roles[0].roleName;
        let projectGroupId = res.payload.data.account.projectGroup.projectGroupId;
        let accountName = res.payload.data.account.firstName+" "+res.payload.data.account.lastName;
        localStorage.setItem('role',role);
        localStorage.setItem('accountName',accountName);
        localStorage.setItem('projectGroupId',projectGroupId);
        if(role === 'SUPERADMIN'){
          setSidebarMenuContent(sidebarMenuContentAdmin);
          
        } else {
          setSidebarMenuContent(sidebarMenuContentNormal);
        }
      })
    } else{
      let role = localStorage.getItem('role'); 
      if(role === 'SUPERADMIN'){
         setSidebarMenuContent(sidebarMenuContentAdmin);
        } else {
          setSidebarMenuContent(sidebarMenuContentNormal);
        } 
    }
  })

  const clickMenu = () => {
    props.onClickMenu();
  }
 
    return (
      <Fragment>
        <PerfectScrollbar>
          <div className="sidebar-navigation"  onClick={()=>clickMenu()}>
            <div className="sidebar-header">
              <span onClick={()=>clickMenu()}>Admin </span>
            </div>
            <MetisMenu
              content={sidebarMenuContent}
              LinkComponent={RouterLink}
              activeLinkFromLocation
              iconNamePrefix=""
              noBuiltInClassNames={true}
              classNameItemActive="active"
              classNameIcon="sidebar-icon"
              iconNameStateVisible="sidebar-icon-indicator"
              iconNameStateHidden="sidebar-icon-indicator"
              classNameItemHasVisibleChild="submenu-open"
              classNameItemHasActiveChild="active"
              classNameStateIcon="pe-7s-angle-down"
            />
          </div>
        </PerfectScrollbar>
      </Fragment>
    );
}
const mapStateToProps = state => ({
   pagination: state.token,
})

export default connect(mapStateToProps,{getLoggedInUserDetails, logOut})(withRouter(SidebarMenu));

