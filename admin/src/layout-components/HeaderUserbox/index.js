import React, { Fragment, Component, useState, useEffect } from 'react';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
// import * as Icon from "react-feather";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { getLoggedInUserDetails, logOut } from '../../config/actions/Auth'

import {
  ListGroup,
  ListGroupItem,
  UncontrolledTooltip,
  Nav,
  NavItem,
  NavLink,
  Button,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu
} from 'reactstrap';

import avatar5 from '../../assets/images/avatars/avatar5.jpg';
import { getToken } from '../../config/actions/Auth'
const  HeaderUserbox = (props) => {
  const [accountName, setAccountName] = useState();
  useEffect(() => {
    let name=localStorage.getItem('accountName');
    setAccountName(name);
  },[props]);
  const logout = () => {
    props.logOut();
    props.history.push('/');
  };
  console.log("username",props.username)
    return (
      <Fragment>
        <UncontrolledDropdown className="user-box position-relative ml-2">
          <DropdownToggle
            color="link"
            className="p-0 text-left d-flex align-items-center">
            <div className="d-block d-44 rounded-sm overflow-hidden">
            </div>
            <div className="d-none d-xl-block pl-2">
              <div className="font-weight-bold">{props.username? props.username : accountName}</div>
            </div>
            <span className="pl-1 pl-xl-3">
              <FontAwesomeIcon
                icon={['fas', 'angle-down']}
                className="opacity-5"
              />
            </span>
          </DropdownToggle>
          <DropdownMenu right className="dropdown-menu-lg overflow-hidden p-0">
            <ListGroup flush className="text-left bg-transparent">
              <ListGroupItem className="rounded-top">
                <Nav pills className="nav-neutral-primary flex-column">
                  <NavItem>
                    <NavLink href="#/" onClick={e => e.preventDefault()}>
                      My Account
                    </NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink className="link-pointer" onClick={()=>logout() }>
                      Logout
                    </NavLink>
                  </NavItem>
                </Nav>
              </ListGroupItem>
            </ListGroup>
          </DropdownMenu>
        </UncontrolledDropdown>
      </Fragment>
    );
  
}


const mapStateToProps = state => ({
   username: state.Auth.username,
})

export default connect(mapStateToProps,{getLoggedInUserDetails, logOut})(withRouter(HeaderUserbox));
