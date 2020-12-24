// import { formatDate, getLinkVersion } from "../../../helpers"

const INTIAL_STATE = {
    token: [],
    username: '',
    userrole:''
}

const Auth = (state = INTIAL_STATE, action) => {
    switch (action.type) {
        case 'GET_TOKEN':
            return {
                ...state,
                token: action.payload
            }
        
        case 'LOGGEDINUSER':
            return {
                ...state,
                username: action.payload.list.firstName+" "+action.payload.list.lastName,
                userrole: action.payload.list.roles[0].roleName
            }
        case 'LOGOUT':
            return {
                ...state,
                token: null
            }
        default:
            return state
    }
}


export default Auth;