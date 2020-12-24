import React, { Fragment, Component } from 'react';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { UncontrolledTooltip, Button } from 'reactstrap';

class PageTitle extends Component {
  render() {
    return (
      <Fragment>
        <div className="app-page-title">
          <div>
            <div className="app-page-title--first">
              <div className="app-page-title--heading">
                <h1>{this.props.titleHeading}</h1>
                <div className="app-page-title--description">
                  {this.props.titleDescription}
                </div>
              </div>
            </div>
          </div>
          <div className="d-flex align-items-center mt-3 mt-lg-0">
            <Button
              size="sm"
              color="primary"
              className="mx-0 mr-3 mr-lg-0 mx-lg-3">
              <span className="btn-wrapper--label">View details</span>
            </Button>
            <Button size="sm" color="success" id="AddEntryTooltip20">
              <span className="btn-wrapper--icon">
                <FontAwesomeIcon
                  icon={['fas', 'plus']}
                  className="opacity-8 font-size-xs"
                />
              </span>
            </Button>
            <UncontrolledTooltip target="AddEntryTooltip20">
              Add new entry
            </UncontrolledTooltip>
          </div>
        </div>
      </Fragment>
    );
  }
}

export default PageTitle;
