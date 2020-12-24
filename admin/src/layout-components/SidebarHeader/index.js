import React, { Fragment, Component } from 'react';

import { Link } from 'react-router-dom';

import projectLogo from '../../assets/images/logo.png';

class SidebarHeader extends Component {
  render() {
    return (
      <Fragment>
        <div className="app-sidebar--header">
          <div className="nav-logo">
            <Link
              to="/dashboard"
              title="HSLynk Admin">
              <i>
                <img
                  alt="HSLynk Admin"
                  src={projectLogo}
                />
              </i>
              <span>HSLynk</span>
            </Link>
          </div>
        </div>
      </Fragment>
    );
  }
}

export default SidebarHeader;
