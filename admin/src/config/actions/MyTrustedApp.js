import { CALL_API } from './axios';
import config from "../../data/config"


export const getTrustedAppProjectGroups = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            // console.log("action",response.data.projectgroups);
            dispatch({
                type: 'trustedprojectgroups',
                payload: {
                    list: response.data.trustedApp
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.trustedApp
            })
        }, (err) => {
            console.log("err",err);
            // if (err.response.status === 401) {
            //     localStorage.setItem('session_token', null)
            //     window.location.href = '/401';
            // }else if (err.response.status === 403) {
            //     localStorage.setItem('session_token', null)
            //     window.location.href = '/';
            // }
        }).catch((ex) => {
            return Promise.reject(ex);
        })
    }
}
