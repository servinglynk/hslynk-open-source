import React, { Fragment } from 'react';

import { Nav, NavItem, NavLink } from 'reactstrap';

function Footer() {
  return (
    <Fragment>
      <div className="app-footer text-black-50">
        <div className="app-footer--second">
          <span>Copyright © 2015-2020, </span> 
          <a href="https://hslynk.com" target="_blank" title="hslynk.com">
              ServingLynk, Inc
          </a>
        </div>
      </div>
    </Fragment>
  );
}

export default Footer;
