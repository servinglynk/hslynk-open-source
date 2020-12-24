import { CALL_API } from './axios';
import config from "../../data/config"

export const getTrustedApps = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            dispatch({
                type: 'trustedApps',
                payload: {
                    list: response.data.trustedApps
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.trustedApps
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
export const getTrustedAppProjectGroups = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            // console.log("action",response.data.projectgroups);
            dispatch({
                type: 'trustedprojectgroups',
                payload: {
                    list: response.data.trustedApps
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
export const getTrustedApp = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            dispatch({
                type: 'trustedApp',
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

export const getUpdatedProjectGroup = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            dispatch({
                type: 'getUpdateProjectGroup',
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

export const updateTrustedApp = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.developer_url + path, type, header, data).then((response) => {
            dispatch({
                type: 'trustedApp',
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

export const updateProjectGroup = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            dispatch({
                type: 'trustedProjectGroupApp',
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


export const addTrustedApp = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            dispatch({
                type: 'trustedApp',
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

export const deleteTrustedApp = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            dispatch({
                type: 'trustedApp',
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




