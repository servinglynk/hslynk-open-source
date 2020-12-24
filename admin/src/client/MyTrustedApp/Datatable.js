import React, { Component, useState, useEffect } from 'react';

import DataTable from 'react-data-table-component';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
import { Badge, InputGroup, InputGroupText, InputGroupAddon, Input } from 'reactstrap';
import { getTrustedAppProjectGroups } from '../../config/actions/TrustedApps'
import  Spinner  from '../../layout-components/Spinner';
import config from "../../data/config"; 

const Index = (props) => {
	const [startIndex, setStartIndex] = useState(0); 
  	const [pageSize, setPageSize] = useState(10); 
  	const [data, setData] = useState([]); 
    const [spinner, setSpinner] = useState(false);
    const [pageno, setPageno] = useState(1);

	useEffect(() => {
		console.log("props",props.data);
		if(!props.data){
        	setSpinner(false);
		} else{
	        setSpinner(true);
		}
        setData(props.data);
	}, [props.data]);

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
        props.getTrustedAppProjectGroups('/trustedapps/'+config.trustedApp_id+'/projectgroups',{},params,'get').then((response)=>{
        	setSpinner(false);
        });
	}

	const searchData = (e) => {
		let text = e.target.value;
		let filteredData = props.data.filter(value => {
            if (value) {
                if(text.length === 0) {
                    return 1
                }
                    if(value.projectGroupName.toLowerCase().includes(text.toLowerCase()) || value.projectGroupDesc.toLowerCase().includes(text.toLowerCase())|| value.projectGroupCode.toLowerCase().includes(text.toLowerCase()))
                        return 1;
                    else
                        return 0;
            }
            return [];
        });
		console.log(filteredData);
		setData(filteredData);
	}

	const onSort = (newSorted, column, shiftKey) => {
		console.log("column",shiftKey);
	}
	return ( 
		<>	
			{ !spinner ?
      			<Spinner loading= {spinner}/>
      		:
			<>
				<InputGroup className="pt-2 pl-2 w-50" size="md">
			        <InputGroupAddon addonType="prepend">
			          <InputGroupText><span className="pe-7s-search"></span></InputGroupText>
			        </InputGroupAddon>
			        <Input  type="text" name="search" placeholder="Search..." onKeyUp={(e)=>searchData(e)} />
			    </InputGroup>
			    <DataTable
			        title="Associated Trusted Apps"
			        columns={props.columns}
			        data={data}
			        pagination={true}
			        paginationServer={true}
			        paginationDefaultPage={pageno}
			        paginationPerPage={pageSize}
			        // paginationTotalRows={props.pagination.total}
			        paginationRowsPerPageOptions={[5,10, 15, 20, 25, 30]}
			        onChangePage = {(page, totalRows) => onChangePage(page, totalRows)}
			        onChangeRowsPerPage ={(currentRowsPerPage, currentPage) => onChangeRowsPerPage(currentRowsPerPage, currentPage)}
			         // sortServer={true}
			        // onSort = {(newSorted, column, shiftKey) => onSort(newSorted, column, shiftKey)}
			    />
		    </>
			}
	    </>
	);
}

const mapStateToProps = state => ({
    data: state.MyTrustedApp.data,
    pagination: state.MyTrustedApp.pagination,
})
export default connect(mapStateToProps,{getTrustedAppProjectGroups})(withRouter(Index));
