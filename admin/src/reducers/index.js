import { combineReducers } from "redux";
import ThemeOptions from './ThemeOptions';
import Projectgroup from './Projectgroup';
import Users from './Users';
import TrustedApps from './TrustedApps';
import Exports from './Exports';
import BulkUploads from './BulkUploads';
import Reports from './Reports';
import Auth from './Auth';
import MyTrustedApp from './MyTrustedApp';
// export default {
//   ThemeOptions,
//   Auth
// };


const reducer = combineReducers({
   ThemeOptions,
   Auth,
   Projectgroup,
   Users,
   TrustedApps,
   Exports,
   BulkUploads,
   Reports,
   MyTrustedApp
});

export default reducer;
