// import { formatDate, getLinkVersion } from "../../../helpers"

const INTIAL_STATE = {
    data: [],
    pagination:[]
}

const Auth = (state = INTIAL_STATE, action) => {
    console.log(state.data);
    switch (action.type) {
        case 'projectGroups':
            return {
                ...state,
                data: action.payload.list.projectGroups,
                pagination: action.payload.list.pagination
           } 
        case 'projectGroup':
            return {
                ...state,
                data: action.payload
            }
        default:
            return state
    }
}


export default Auth;