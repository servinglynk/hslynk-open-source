import axios from "axios";
import config from "../../data/config"

export var CALL_API = (url, type, header = {}, data = {}) => {
  const token = localStorage.getItem('session_token');
  let reqHeader = Object.assign(header, {
    Accept: "application/json",
    "Content-Type": "application/json",
    'authorization': 'HMISUserAuth session_token=' + token,
    'x-hmis-trustedapp-id': config.trustedApp_id
  });

  if (type === "get") {
    return axios
      .get(url, { params: data, headers: reqHeader })
      .then(
        response => {
          return Promise.resolve(response);
        },
        err => {
          return Promise.reject(err);
        }
      )
      .catch(ex => {
        return Promise.reject(ex);
      });
  } else if (type === "post") {
    return axios
      .post(url, data, { headers: reqHeader })
      .then(
        response => {
          return Promise.resolve(response);
        },
        err => {
          return Promise.reject(err);
        }
      )
      .catch(ex => {
        return Promise.reject(ex);
      });
  } else if (type === "delete") {
    return axios
      .delete(url, { headers: reqHeader })
      .then(
        response => {
          return Promise.resolve(response);
        },
        err => {
          return Promise.reject(err);
        }
      )
      .catch(ex => {
        return Promise.reject(ex);
      });
  } else if (type === "put") {
    return axios
      .put(url, data, { headers: reqHeader })
      .then(
        response => {
          return Promise.resolve(response);
        },
        err => {
          return Promise.reject(err);
        }
      )
      .catch(ex => {
        return Promise.reject(ex);
      });
  }
};


export var CALL_API_DOWNLOAD = (url, type,  header = {}, data = {}) => {
  const token = localStorage.getItem('session_token');
  let reqHeader = Object.assign(header, {
    Accept: "multipart/form-data",   
    "Content-Type": "multipart/form-data",
    'authorization': 'HMISUserAuth session_token=' + token,
    'x-hmis-trustedapp-id': config.trustedApp_id
  });

  if (type === "get") {
    return axios
      .get(url, { params: data, headers: reqHeader,  responseType: 'arraybuffer' })
      .then(
        response => {
          return Promise.resolve(response);
        },
        err => {
          return Promise.reject(err);
        }
      )
      .catch(ex => {
        return Promise.reject(ex);
      });
  } else if (type === "post") {
    return axios
      .post(url, data, { headers: reqHeader })
      .then(
        response => {
          return Promise.resolve(response);
        },
        err => {
          return Promise.reject(err);
        }
      )
      .catch(ex => {
        return Promise.reject(ex);
      });
  } else if (type === "delete") {
    return axios
      .delete(url, { headers: reqHeader })
      .then(
        response => {
          return Promise.resolve(response);
        },
        err => {
          return Promise.reject(err);
        }
      )
      .catch(ex => {
        return Promise.reject(ex);
      });
  } else if (type === "put") {
    return axios
      .put(url, data, { headers: reqHeader })
      .then(
        response => {
          return Promise.resolve(response);
        },
        err => {
          return Promise.reject(err);
        }
      )
      .catch(ex => {
        return Promise.reject(ex);
      });
  }
};