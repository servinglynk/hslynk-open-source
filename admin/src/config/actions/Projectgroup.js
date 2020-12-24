import { CALL_API } from './axios';
import config from "../../data/config"

export const getProjectGroups = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            // console.log("action",response.data.projectgroups);
            dispatch({
                type: 'projectGroups',
                payload: {
                    list: response.data.projectgroups
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.projectgroups
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


export const getProjectGroup = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            // console.log("action",response.data.projectGroup);
            dispatch({
                type: 'projectGroup',
                payload: {
                    list: response.data.projectGroup
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.projectGroup
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

export const updateProjectGroup = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            // console.log("action",response.data.projectGroup);
            dispatch({
                type: 'projectGroup',
                payload: {
                    list: response.data.projectGroup
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.projectGroup
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

export const addProjectGroup = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            // console.log(response);
            dispatch({
                type: 'projectGroup',
                payload: {
                    list: response.data
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data
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

export const deleteProjectGroup = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            console.log(response);
            dispatch({
                type: 'projectGroup',
                payload: {
                    list: response.data
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data
            })
        }, (err) => {
            console.log("err",err);
        }).catch((ex) => {
            return Promise.reject(ex);
        })
    }
}



