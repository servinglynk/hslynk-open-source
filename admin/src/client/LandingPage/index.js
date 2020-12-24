import React, { Fragment } from 'react';

import { Row, Col } from 'reactstrap';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { Link } from 'react-router-dom';
import config from '../../data/config';
import hero9 from '../../assets/images/hero-bg/hero-9.jpg';
import logo from '../../assets/images/logoSite.png';
import { Button, UncontrolledTooltip, Badge } from 'reactstrap';

const LandingPage = () => {
  return (
    <Fragment>
      <div className="login-page">
        <div className="top-header text-right">
          <a href={`https://admin.hmislynk.com/hmis-authorization-service/login-web.html?response_type=code&errorMessage=null&trustedApp_id=${config.trustedApp_id}&state=xyzvalue&redirect_uri=${config.redirect_url}&access_type=online&approval_prompt=auto`} className="btn btn-warning">Login</a>
        </div>
        <header>
          <div className="container">
            <div className="row align-items-center">
              <div className="col-6">
                  <img src={logo} className="img-fluid" alt="logo"/>
              </div>
              <div className="col-6 text-center">
                  <h2>Welcome to HSLynk</h2>
              </div>
            </div>
          </div>
        </header>
        <footer>
          <p>   
              Copyright © 2015-2020 All rights reserved. ServingLynk, Inc
          </p>
        </footer>
      </div>
    </Fragment>
  );
};

export default LandingPage;
