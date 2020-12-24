import { CALL_API } from './axios';
import config from "../../data/config"

export const getBulkUploads = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.upload_url + path, type, header, data).then((response) => {
            // console.log("action",response.data.projectgroups);
            dispatch({
                type: 'bulkuploads',
                payload: {
                    list: response.data.BulkUploads
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.BulkUploads
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

export const getActiveLogBulkUploads = (path, header, data, type) => {
    console.log(path);
    console.log(header);
    console.log(data);
    console.log(type);
    return (dispatch, getState) => {
        let finalPath = path;
        if(process.env.NODE_ENV === 'production') {
            finalPath = '/api/'+path;
        }
        return CALL_API(finalPath, type, header, data).then((response) => {
            console.log(response.data);
            // console.log("action",response.data.projectGroup);
            dispatch({
                type: 'bulkuploadActivelogs',
                payload: {
                    list: response.data.bulkUploadActivities
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.bulkUploadActivities
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

export const getErrorsBulkUploads = (path, header, data, type) => {
    console.log(path);
    console.log(header);
    console.log(data);
    console.log(type);
    return (dispatch, getState) => {
        let finalPath = path;
        if(process.env.NODE_ENV === 'production') {
            finalPath = '/api/'+path;
        }
        return CALL_API(finalPath, type, header, data).then((response) => {
            console.log(response.data);
            // console.log("action",response.data.projectGroup);
            dispatch({
                type: 'bulkuploaderror',
                payload: {
                    list: response.data.bulkUploadErrors
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.bulkUploadErrors
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



export const getBulkUpload = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.upload_url + path, type, header, data).then((response) => {
            // console.log("action",response.data.projectGroup);
            dispatch({
                type: 'bulkupload',
                payload: {
                    list: response.data.BulkUploads
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

export const getBulkUploadActivity = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.upload_url + path, type, header, data).then((response) => {
            // console.log("action",response.data.projectGroup);
            dispatch({
                type: 'bulkupload',
                payload: {
                    list: response.data.BulkUploads
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

export const addBulkUpload= (path, header, data, type) => {
    console.log(config.upload_url + path)
    console.log(header);
    console.log(data);
    console.log(type);
    return (dispatch, getState) => {
        return CALL_API(config.upload_url + path, type, header, data).then((response) => {
            // console.log(response);
            dispatch({
                type: 'bulkupload',
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

