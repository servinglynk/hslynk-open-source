import React, { Fragment } from 'react';

import { Row, Col, Card, Progress } from 'reactstrap';

const SuperAdminDashboard = () => {
  return (
    <Fragment>
      <Row>
        <Col md="6" xl="3">
          <Card className="p-3 mb-5 bg-midnight-bloom">
            <div className="align-box-row">
              <div className="text-warning font-size-xl font-weight-bold pr-2">
                101
              </div>
            </div>
            <div className="text-white-50 pt-2">Users</div>
          </Card>
        </Col>
        <Col md="6" xl="3">
          <Card className="p-3 mb-5 bg-midnight-bloom">
            <div className="align-box-row">
              <div className="text-warning font-size-xl font-weight-bold pr-2">
                56
              </div>
            </div>
            <div className="text-white-50 pt-2">Project Groups</div>
          </Card>
        </Col>
        <Col md="6" xl="3">
          <Card className="p-3 mb-5 bg-midnight-bloom">
            <div className="align-box-row">
              <div className="text-warning font-size-xl font-weight-bold pr-2">
                17
              </div>
            </div>
            <div className="text-white-50 pt-2">Trusted Apps</div>
          </Card>
        </Col>
        <Col md="6" xl="3">
          <Card className="p-3 mb-5 bg-midnight-bloom">
            <div className="align-box-row">
              <div className="text-warning font-size-xl font-weight-bold pr-2">
                83
              </div>
            </div>
            <div className="text-white-50 pt-2">XYZ</div>
          </Card>
        </Col>
      </Row>
    </Fragment>
  );
}
export default SuperAdminDashboard;