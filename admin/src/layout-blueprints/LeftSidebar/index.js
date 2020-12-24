import React, { Fragment, useEffect } from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import { Sidebar, Header, Footer } from '../../layout-components';

const LeftSidebar = props => {
  const { children } = props;
  
  return (
    <Fragment>
      <div className="app-wrapper app-sidebar-fixed app-header-fixed">
        <div>
          <Sidebar />
        </div>
        <div className="app-main">
          <Header />
          <div className="app-content">
            <div className="app-content--inner">
              <div className="app-content--inner__wrapper">{children}</div>
            </div>
            <Footer />
          </div>
        </div>
      </div>
    </Fragment>
  );
};

LeftSidebar.propTypes = {
  children: PropTypes.node
};

const mapStateToProps = state => ({
  sidebarToggleMobile: state.ThemeOptions.sidebarToggleMobile
});

export default connect(mapStateToProps)(LeftSidebar);
