// import { formatDate, getLinkVersion } from "../../../helpers"

const INTIAL_STATE = {
    data: [],
    reportProjectLits:[],
    reportCocLits:[],
    selectedProject:[],
    pagination:[]
}

const Reports = (state = INTIAL_STATE, action) => {
    switch (action.type) {
        case 'reports':
            return {
                ...state,
                data: action.payload.list,
                pagination: action.payload.pagination
           } 
        case 'report':
            return {
                ...state,
                data: action.payload
            }
        case 'resportsProject':
            return {
                ...state,
                reportProjectLits: action.payload.list.projects
            }

        case 'resportsProjectCoc':
            return {
                ...state,
                reportCocLits: action.payload.list.projectCocs
            }

        case 'selectedProject':
            return {
                ...state,
                selectedProject:  action.payload.list
            }

        default:
            return state
    }
}


export default Reports;