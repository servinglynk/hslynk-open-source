import { CALL_API, CALL_API_DOWNLOAD } from './axios';
import config from "../../data/config"
import { formatDate } from "../../helpers";

export const getReports = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.report_url + path, type, header, data).then((response) => {
            console.log("action",response.data);
            const FileReports = [];
            response.data.ReportConfigs.reportConfigs.map(data => {
                const createdBy = data.createdBy
                const dateCreated =  data.dateCreated
                const dateUpdated =  data.dateUpdated
                const emailSent =  data.emailSent
                const endDate =  data.endDate ? formatDate(new Date( data.endDate))  : ""
                const reportType =  data.reportType
                const reportLevel =  data.reportLevel
                const id =  data.id
                const name =  data.name
                const projectGroupCode =  data.projectGroupCode
                const projectIds =  data.projectIds
                const startDate = formatDate(new Date(data.startDate))  
                const status =  data.status
                const updatedBy =  data.updatedBy

           const mergeData = {
            id,
            createdBy,
            dateCreated,
            dateUpdated,
            endDate,
            reportType,
            reportLevel,
            emailSent,
            name,
            projectGroupCode,
            projectIds,
            startDate,
            status,
            updatedBy
        }
        FileReports.push(mergeData)

        })

            dispatch({
                type: 'reports',
                payload: {
                    list: FileReports,
                    pagination:response.data.ReportConfigs.pagination
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response
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


export const downloadFile = (path) => {
    console.log("pathtitle", path);
    return (dispatch, getState) => {
        return CALL_API_DOWNLOAD(config.report_url + '/reports/download/' + path + "/zip", 'get', {}).then((response) => {           
            dispatch({
                type: 'export',
            });
            return Promise.resolve({
                status: response.status,
                data: response.data
            })
        }, (err) => {
            console.log("errorrrr", err);
            return Promise.resolve({
                status: err.response.status,
                payload: err.response.data  .errors && err.response.data.errors.error[0].message
            })
        }).catch((ex) => {
            return Promise.reject(ex);
        })
    }
}

export const getReportsProject = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.base_url + path, type, header, data).then((response) => {
            console.log("action",response.data);
            dispatch({
                type: 'resportsProject',
                payload: {
                    list: response.data.projects
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.projects
            })
        }, (err) => {
            console.log("err",err);
        }).catch((ex) => {
            return Promise.reject(ex);
        })
    }
}

export const getSelectedProjectList = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.base_url + path, type, header, data).then((response) => {
            console.log("action",response.data);
            dispatch({
                type: 'selectedProject',
                payload: {
                    list: response.data.project
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.project
            })
        }, (err) => {
            console.log("err",err);
        }).catch((ex) => {
            return Promise.reject(ex);
        })
    }
}



export const getReport = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.report_url + path, type, header, data).then((response) => {
            // console.log("action",response.data.projectGroup);
            dispatch({
                type: 'report',
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

export const addReport = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(config.report_url + path, type, header, data).then((response) => {
            // console.log(response);
            dispatch({
                type: 'report',
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


export const getCocCode = (path, header, data, type) => {
    return (dispatch, getState) => {
        return CALL_API(path, type, header, data).then((response) => {
            console.log("action",response.data.projectCocs);
            dispatch({
                type: 'resportsProjectCoc',
                payload: {
                    list: response.data.projectCocs
                }
            });
            return Promise.resolve({
                status: response.status,
                payload: response.data.projectCocs
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


