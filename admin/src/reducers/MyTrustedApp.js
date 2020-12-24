// import { formatDate, getLinkVersion } from "../../../helpers"

const INTIAL_STATE = {
    data: [],
    pagination:[]
}

const MyTrustedApp = (state = INTIAL_STATE, action) => {
    switch (action.type) {
        case 'trustedprojectgroups':
            return {
                ...state,
                data: action.payload.list.trustedApp,
                pagination: action.payload.list.pagination
           } 
        case 'trustedApp':
            return {
                ...state,
                data: action.payload
            }
        default:
            return state
    }
}


export default MyTrustedApp;