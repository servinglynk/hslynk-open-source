const INTIAL_STATE = {
    data: [],
    error:[],
    log:[],
    pagination:[]
}

const BulkUploads = (state = INTIAL_STATE, action) => {
    switch (action.type) {
        case 'bulkuploads':
            return {
                ...state,
                data: action.payload.list.bulkUploads,
                pagination: action.payload.list.pagination
           } 
        case 'bulkupload':
            return {
                ...state,
                data: action.payload
            }
        case 'bulkuploaderror':
            return {
                ...state,
                error: action.payload.list.bulkUploadErrors
            }
        case 'bulkuploadActivelogs':
            return {
                ...state,
                log: action.payload.list.bulkUploadActivities
            }

        default:
            return state
    }
}


export default BulkUploads;