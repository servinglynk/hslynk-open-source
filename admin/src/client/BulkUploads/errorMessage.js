import React, { Fragment,useEffect,useState } from 'react';
import {withRouter} from 'react-router-dom'
import {Card,CardHeader} from 'reactstrap'
import CardBody from 'reactstrap/lib/CardBody';
import DataTable from 'react-data-table-component';
import { connect } from 'react-redux';
import  Spinner  from '../../layout-components/Spinner';
import { getErrorsBulkUploads } from '../../config/actions/BulkUploads'
const ErrorMessage = (props) => {
    const [data, setData] = useState([]); 
    const [startIndex, setStartIndex] = useState(0); 
    const [pageSize, setPageSize] = useState(10); 
    const [spinner, setSpinner] = useState(false);
    const [pageno, setPageno] = useState(1);
    const [id,setId] = useState(localStorage.getItem("id"))
    const [year,setYear] = useState(localStorage.getItem("year"))
    useEffect(() => {

        setSpinner(false);
        setData(props.data)
        // localStorage.setItem("id",props.location.state.id)
        // localStorage.setItem("year",props.location.state.year)   
        // setId(props.location.state.id)
        // setYear(props.location.state.year)
    },[props.data])
    console.log(data);
    console.log(props.location.state.id);

    const onChangePage = (page, totalRows) => {
		console.log("page",page);
        setSpinner(true);
		let startIndex = pageSize * (page-1);
		getData(startIndex,pageSize);
		setPageno(page);
    }

    const onChangeRowsPerPage = (currentRowsPerPage, currentPage) => {
        setSpinner(true);
		setPageSize(currentRowsPerPage);
		getData(startIndex,currentRowsPerPage);
    }
    
    
    const getData= (startIndex,pageSize) =>{
		const params = {
	    	startIndex : startIndex,
	        maxItems : pageSize
        };
        
        props.getErrorsBulkUploads(`/hmis-clientapi-v${year}/rest/bulkupload/errors/${id}`,{},params,'get').then((response) => {
            setSpinner(false);
          })

        // props.getProjectGroups('/projectgroups',{},params,'get').then((response)=>{
        // 	setSpinner(false);
        // });
    }
    


    const columns = [
        {
            name: 'TableName',
            selector: 'table_name',
            sortable: true,
            maxWidth:'20%'
        },
        {
            name: 'Status',
            selector: 'type',
            sortable: true,
            maxWidth:'20%'
        },
        {
            name: 'Source Id',
            selector: 'source_system_id',
            sortable: true,
            maxWidth:'20%'
        },
        {
            name: 'Description',
            selector: 'error_description',
            sortable: true,
            maxWidth:'20%'
        }
    ]
    return (
        <Fragment>
            { spinner ?
      			<Spinner loading= {spinner}/>
              :
              
          <Card className="card-box mb-5">
            <CardHeader>
                <div className="card-header--title">
                    <h3>Error Message</h3>
                </div>
            </CardHeader>  
            <CardBody>
            <div className="table-responsive-md table-title">
                <DataTable
                    title="Error List"
                    columns={columns}
                    data={data}
                    pagination={true}
			        // paginationServer={true}
			        paginationDefaultPage={pageno}
			        paginationPerPage={pageSize}
			        paginationTotalRows={props.pagination.total}
			        paginationRowsPerPageOptions={[5,10, 15, 20, 25, 30]}
			        onChangePage = {(page, totalRows) => onChangePage(page, totalRows)}
			        onChangeRowsPerPage ={(currentRowsPerPage, currentPage) => onChangeRowsPerPage(currentRowsPerPage, currentPage)}
                />
            </div>
            </CardBody>
            </Card>
            }
        </Fragment>
    );
}
const mapStateToProps = state => ({
    data: state.BulkUploads.error,
    pagination: state.BulkUploads.pagination,
 })
export default connect(mapStateToProps,{getErrorsBulkUploads})(withRouter(ErrorMessage));