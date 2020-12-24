// import { formatDate, getLinkVersion } from "../../../helpers"

const INTIAL_STATE = {
    data: [],
    pagination:[],
    role:[],
    profile:[]
}

const Auth = (state = INTIAL_STATE, action) => {
    switch (action.type) {
        case 'users':
            return {
                ...state,
                data: action.payload.list.account,
                pagination: action.payload.list.pagination
           } 
        case 'user':
            return {
                ...state,
                data: action.payload
            }

        case 'roleList':
            return {
                ...state,
                role: action.payload.list
            }

        case 'profileList':
            return {
                ...state,
                profile: action.payload.list
            }
        default:
            return state
    }
}


export default Auth;