import React, { Fragment, Component } from 'react';
import clsx from 'clsx';

import { connect } from 'react-redux';

import { setSidebarToggleMobile } from '../../reducers/ThemeOptions';

import { SidebarHeader, SidebarMenu } from '../../layout-components';

class Sidebar extends Component {
  toggleSidebarMobile = () => {
    let { sidebarToggleMobile, setSidebarToggleMobile } = this.props;
    setSidebarToggleMobile(!sidebarToggleMobile);
  };

  render() {
    let { sidebarToggleMobile } = this.props;

    return (
      <Fragment>
        <div className={clsx('app-sidebar app-sidebar--dark', {
            'show': sidebarToggleMobile
          }) }>
          <SidebarHeader />
          <div className="app-sidebar--content">
            <SidebarMenu onClickMenu={this.toggleSidebarMobile}/>
          </div>
        </div>
        <div
          onClick={this.toggleSidebarMobile}
          className={clsx('app-sidebar-overlay', {
            'is-active': sidebarToggleMobile
          }) }
        />
      </Fragment>
    );
  }
}

const mapStateToProps = state => ({
  sidebarToggleMobile: state.ThemeOptions.sidebarToggleMobile
});

const mapDispatchToProps = dispatch => ({
  setSidebarToggleMobile: enable => dispatch(setSidebarToggleMobile(enable))
});

export default connect(mapStateToProps, mapDispatchToProps)(Sidebar);
