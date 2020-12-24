const INTIAL_STATE = {
    data: [],
    groupData:[],
    updatedGroup:[],
    pagination:[]
}

const TrustedApps = (state = INTIAL_STATE, action) => {
    switch (action.type) {
        case 'trustedApps':
            return {
                ...state,
                data: action.payload.list.trustedApp,
                pagination: action.payload.list.pagination
           } 
        case 'trustedprojectgroups':
            return {
                ...state,
                data: action.payload.list.projectGroups,
                pagination: action.payload.list.pagination
           }
        case 'trustedApp':
            return {
                ...state,
                data: action.payload
            }

        case 'trustedApp':
        return {
            ...state,
            groupData: action.payload
        }

        case 'getUpdateProjectGroup':
        return {
            ...state,
            updatedGroup: action.payload.list.projectGroups
        }

        default:
            return state
    }
}


export default TrustedApps;