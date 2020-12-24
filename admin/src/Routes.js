import React, { lazy, Suspense, useState, useEffect } from 'react';
import { Switch, Route, Redirect, useLocation } from 'react-router-dom';
import { AnimatePresence, motion } from 'framer-motion';

// Layout Blueprints

import { LeftSidebar, PresentationLayout } from './layout-blueprints';

// Example Pages



const LandingPage = lazy(() => import('./client/LandingPage'));
const Auth = lazy(() => import('./client/LandingPage/Redirect'));
const DashboardDefault = lazy(() => import('./client/DashboardDefault'));
const ProjectGroup = lazy(() => import('./client/ProjectGroup'));
const ProjectGroupCreate = lazy(() => import('./client/ProjectGroup/create'));
const ProjectGroupEdit = lazy(() => import('./client/ProjectGroup/edit'));
const ProjectGroupView = lazy(() => import('./client/ProjectGroup/view'));

const Users = lazy(() => import('./client/Users'));
const UsersCreate = lazy(() => import('./client/Users/create'));
const UsersEdit = lazy(() => import('./client/Users/edit'));
const UsersView = lazy(() => import('./client/Users/view'));

const MyTrustedApp = lazy(() => import('./client/MyTrustedApp'));

const TrustedApps = lazy(() => import('./client/TrustedApps'));
const TrustedAppsEdit = lazy(() => import('./client/TrustedApps/edit'));
const TrustedAppsView = lazy(() => import('./client/TrustedApps/view'));

const BulkUpload = lazy(() => import('./client/BulkUploads'));
const BulkUploadCreate = lazy(() => import('./client/BulkUploads/upload'));
// const BulkUploadCreate = lazy(() => import('./client/BulkUploads/create'));
const BulkUploadEdit = lazy(() => import('./client/BulkUploads/edit'));
const BulkUploadError = lazy(() => import('./client/BulkUploads/errorMessage'));

const Export = lazy(() => import('./client/Exports'));
const ExportCreate = lazy(() => import('./client/Exports/create'));
const ExportEdit = lazy(() => import('./client/Exports/edit'));

const Reports = lazy(() => import('./client/Reports'));
const ReportsCreate = lazy(() => import('./client/Reports/create'));
const ReportsEdit = lazy(() => import('./client/Reports/edit'));


const Routes = () => {
  const location = useLocation();
  const [patharr, setPatharr] = useState([]);
  const pageVariants = {
    initial: {
      opacity: 0,
      scale: 0.99
    },
    in: {
      opacity: 1,
      scale: 1
    },
    out: {
      opacity: 0,
      scale: 1.01
    }
  };

  const pageTransition = {
    type: 'tween',
    ease: 'anticipate',
    duration: 0.4
  };
console.log("role route", localStorage.getItem('role'));
  useEffect(() => {

    if(localStorage.getItem('role')!== 'SUPERADMIN' ){
      setPatharr([
        '/dashboard',
        '/ProjectGroups',
        '/ProjectGroups/create',
        '/ProjectGroups/:id/edit/',
        '/ProjectGroups/:id',
        '/Users',
        '/Users/create',
        '/Users/edit/:id',
        '/Users/:id',
        // '/MyTrustedApp',
        // '/TrustedApps',
        // '/TrustedApps/create',
        // '/TrustedApps/edit/:id',
        // '/TrustedApps/:id',
        '/BulkUploads',
        '/BulkUploads/create',
        '/BulkUploads/edit/:id',
        '/Exports',
        '/Exports/create',
        '/Exports/edit/:id',
        '/Reports',
        '/Reports/create',
        '/Reports/edit/:id'
      ]);
    } else {
      setPatharr([
        '/dashboard',
        '/ProjectGroups',
        '/ProjectGroups/create',
        '/ProjectGroups/:id/edit/',
        '/ProjectGroups/:id',
        '/Users',
        '/Users/create',
        '/Users/edit/:id',
        '/Users/:id',
        '/MyTrustedApp',
        '/TrustedApps',
        '/TrustedApps/create',
        '/TrustedApps/edit/:id',
        '/TrustedApps/:id',
        '/BulkUploads',
        '/BulkUploads/create',
        '/BulkUploads/edit/:id',
        '/Exports',
        '/Exports/create',
        '/Exports/edit/:id',
        '/Reports',
        '/Reports/create',
        '/Reports/edit/:id',
      ]);
    }
  },[])
  return (
    <AnimatePresence>
      <Suspense
        fallback={
          <div className="d-flex align-items-center vh-100 justify-content-center text-center font-weight-bold font-size-lg py-3">
            <div className="w-50 mx-auto">
              Loading...
            </div>
          </div>
        }>
        <Switch>
          <Redirect exact from="/" to="/home" />
          <Route path={['/home']}>
            <PresentationLayout>
              <Switch location={location} key={location.pathname}>
                <motion.div
                  initial="initial"
                  animate="in"
                  exit="out"
                  variants={pageVariants}
                  transition={pageTransition}>
                  <Route path="/home" component={LandingPage} />
                </motion.div>
              </Switch>
            </PresentationLayout>
          </Route>
          <Route path="/auth/redirect" component={Auth} />
          <Route
            path={patharr}>
            <LeftSidebar>
              <motion.div
                initial="initial"
                animate="in"
                exit="out"
                variants={pageVariants}
                transition={pageTransition}>
                <Route
                  path="/dashboard"
                  component={DashboardDefault}
                />
                <Switch location={location} key={location.pathname}>
                    <Route exact path="/ProjectGroups" component={ProjectGroup} />
                    <Route exact path="/ProjectGroups/create" component={ProjectGroupCreate} />
                    <Route exact path="/ProjectGroups/:id/edit" component={ProjectGroupEdit} />
                    <Route exact path="/ProjectGroups/:id" component={ProjectGroupView} />
                    
                    <Route exact path="/Users" component={Users} />
                    <Route exact path="/Users/create" component={UsersCreate} />
                    <Route exact path="/Users/:id/edit" component={UsersEdit} />
                    <Route exact path="/Users/:id" component={UsersView} />

                    <Route exact path="/MyTrustedApp" component={MyTrustedApp} />

                    <Route exact path="/TrustedApps" component={TrustedApps} />
                    <Route exact path="/TrustedApps/:id/edit" component={TrustedAppsEdit} />
                    <Route exact path="/TrustedApps/:id" component={TrustedAppsView} />

                    <Route exact path="/BulkUploads" component={BulkUpload} />
                    <Route exact path="/BulkUploads/create" component={BulkUploadCreate} />
                    <Route exact path="/BulkUploads/edit/:id" component={BulkUploadEdit} />
                    <Route exact path="/BulkUploads/errorMessage/:id" component={BulkUploadError} />
                    
                    <Route exact path="/Exports" component={Export} />
                    <Route exact path="/Exports/create" component={ExportCreate} />
                    <Route exact path="/Exports/edit/:id" component={ExportEdit} />
                  
                    <Route exact path="/Reports" component={Reports} />
                    <Route exact path="/Reports/create" component={ReportsCreate} />
                    <Route exact path="/Reports/edit/:id" component={ReportsEdit} />
                    
                </Switch>
              </motion.div>
            </LeftSidebar>
          </Route>
        </Switch>
      </Suspense>
    </AnimatePresence>
  );
};

export default Routes;
