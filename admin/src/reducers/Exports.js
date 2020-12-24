// import { formatDate, getLinkVersion } from "../../../helpers"

const INTIAL_STATE = {
    data: [],
    exportProjectLits:[],
    pagination:[],
    selectedProject:[]
}


const Exports = (state = INTIAL_STATE, action) => {
    console.log(action.payload);
    switch (action.type) {
        case 'exports':
            return {
                ...state,
                data: action.payload.list,
                pagination: action.payload.pagination
           } 
        case 'export':
            return {
                ...state,
                data: action.payload
            }

        case 'exportsProject':
            return {
                ...state,
                exportProjectLits: action.payload.list.projects
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


export default Exports;