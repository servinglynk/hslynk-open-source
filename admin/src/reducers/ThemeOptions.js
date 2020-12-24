// Sidebar
export const SET_SIDEBAR_TOGGLE_MOBILE =
  'THEME_OPTIONS/SET_SIDEBAR_TOGGLE_MOBILE';

export const setSidebarToggleMobile = sidebarToggleMobile => ({
  type: SET_SIDEBAR_TOGGLE_MOBILE,
  sidebarToggleMobile
});

export default function reducer(
  state = {
    sidebarToggleMobile: false
  },
  action
) {
  switch (action.type) {
    case SET_SIDEBAR_TOGGLE_MOBILE:
      return {
        ...state,
        sidebarToggleMobile: action.sidebarToggleMobile
      };
    default:
      break;
  }
  return state;
}
