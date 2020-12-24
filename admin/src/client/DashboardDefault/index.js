import React, { Fragment } from 'react';

import { PageTitle } from '../../layout-components';

// import DashboardDefaultSection1 from '../../example-components/DashboardDefault/DashboardDefaultSection1';
// import DashboardDefaultSection2 from '../../example-components/DashboardDefault/DashboardDefaultSection2';
// import DashboardDefaultSection3 from '../../example-components/DashboardDefault/DashboardDefaultSection3';
// import DashboardDefaultSection4 from '../../example-components/DashboardDefault/DashboardDefaultSection4';
import SuperAdminDashboard from './SuperAdminDashboard';

export default function DashboardDefault() {
  let role = localStorage.getItem('role');
  console.log("role",role);
  return (
    <Fragment>
      {role ==='SUPERADMIN' ?
        <>
        <PageTitle
          titleHeading="Dashboard"
          titleDescription="Welcome to HSLynk customer admin application"
        />
        <SuperAdminDashboard />
         </>
       :
       <>
        <PageTitle
          titleHeading="Dashboard"
          titleDescription="Welcome to HSLynk Super admin application"
        />
         </>
        }
    </Fragment>
  );
}
