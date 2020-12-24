import { CALL_API } from './axios';
import axios from "axios";

import config from "../../data/config"

export const getToken = (authcode) => {
    return (dispatch, getState) => {
        const apiurl = "/token?grant_type=authorization_code&code=" + authcode + "&redirect_uri=" + config.redirect_url;
        const authorization = new Buffer( config.trustedApp_id+":"+config.trustedApp_secret);
        const reqHeader = {
            'Authorization': 'Basic:' + authorization.toString('base64'),
            'X-HMIS-TrustedApp-Id': config.trustedApp_id,
        }
       
        return axios.post(config.base_auth_url + apiurl, null, { headers: reqHeader }).then((response) => {
            dispatch({
                type: 'GET_TOKEN',
                payload: response.data.oAuthAuthorization.accessToken
            });
            return Promise.resolve({
                status: response.status,
                token: response.data.oAuthAuthorization.accessToken
            })
        }, (err) => {
            return Promise.reject(err);
        }).catch((ex) => {
            return Promise.reject(ex);
        })
    }
}

export const getLoggedInUserDetails = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, 'get', header, data).then((response) => {
            var loggedInUserData = response.data.account;
            // var pagination = {};
            if (loggedInUserData !== null) {
                localStorage.setItem('loggedInUserData', JSON.stringify(loggedInUserData));
            }

            dispatch({
                type: 'LOGGEDINUSER',
                payload: {
                    list: loggedInUserData
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response
            })
        }, (err) => {
            if (err.response.status === 401) {
                localStorage.setItem('session_token', null)
                window.location.href = '/401';
            }else if (err.response.status === 403) {
                localStorage.setItem('session_token', null)
                window.location.href = '/';
            }
        }).catch((ex) => {
            return Promise.reject(ex);
        })
    }
}

export const logOut = () => {
    return (dispatch, getState) => {
        localStorage.clear();
        localStorage.setItem("session_token", null);
        dispatch({
            type: 'LOGOUT',
        });
    }
}



