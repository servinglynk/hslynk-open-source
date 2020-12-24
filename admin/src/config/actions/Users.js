import { CALL_API } from './axios';
import config from "../../data/config"

export const getUsers = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            console.log("action",response.data.accounts);
            dispatch({
                type: 'users',
                payload: {
                    list: response.data.accounts
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.accounts
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

export const getUser = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            // console.log("action",response.data.projectGroup);
            dispatch({
                type: 'user',
                payload: {
                    list: response.data.account
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.account
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


export const getRole = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            console.log("action",response.data.roles.role);
            dispatch({
                type: 'roleList',
                payload: {
                    list: response.data.roles.role
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.roles.role
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


export const getProfile = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            console.log("profile action",response.data.profiles.profile);
            dispatch({
                type: 'profileList',
                payload: {
                    list: response.data.profiles.profile
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.profiles.profile
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



export const updateUser = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            // console.log("action",response.data.projectGroup);
            dispatch({
                type: 'user',
                payload: {
                    list: response.data.account
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.account
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

export const addUser = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            // console.log(response);
            dispatch({
                type: 'user',
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

export const deleteUser = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.user_url + path, type, header, data).then((response) => {
            console.log(response);
            dispatch({
                type: 'user',
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