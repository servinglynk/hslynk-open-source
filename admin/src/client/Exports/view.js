import React, { Fragment, useState, useEffect } from 'react';
import { Card } from 'reactstrap';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
import SweetAlert from 'react-bootstrap-sweetalert';
import { ToastContainer, toast } from 'react-toastify';

import { getProjectGroup, deleteProjectGroup } from '../../config/actions/Projectgroup'
import  Breadcrumb  from '../../layout-components/Breadcrumb'

const View = (props) => {
 const [fields, setFields] = useState({
 	projectGroupName:'',
 	projectGroupDesc:'',
	projectGroupCode:'',
	bucketName:''
 });
  const [Alert,setAlert] = useState(false);
  const [projectGroupId,setProjectGroupId] = useState('');
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);

	useEffect(() => {
		getBreadCrumbItems();
	    props.getProjectGroup('/projectgroups/'+props.match.params.id,{},{},'get').then((response) => {
	        setFields({
	          projectGroupName:response.payload.projectGroupName,
	          projectGroupDesc:response.payload.projectGroupDesc,
	          projectGroupCode:response.payload.projectGroupCode,
	          bucketName:response.payload.bucketName,
	        });
	        // setProjectGroups(response.data.projectgroups.projectGroups);
	      }).catch((ex) => {
	        console.log('error', ex);
	    })
	 }, []);
	const getBreadCrumbItems = () => {
    var paths = window.location.pathname.split("/")
    var url = window.location.pathname;
    const urls = []
    paths.forEach(() => {
        url = url.substring(0, url.lastIndexOf('/'))
         if (url !== ""){
            if(url == '/admin') {
              url = '/dashboard';
            }
            urls.push({ link: url, name: url.split("/").pop() })
          }
    })
    setBreadcrumbItems(urls.reverse());
  }
const deleteRow = (id) =>{
  setProjectGroupId(id);
  setAlert(true);
}

const confirmDelete = () => {
  setAlert(false);
  props.deleteProjectGroup('/projectgroups/'+projectGroupId,{},{},'delete').then((response) => {
    if(response.status==200){
        toast.success("ProjectGroup deleted successfully")
        props.history.push('/ProjectGroups');
    }
  }).catch((ex) => {
    console.log('error', ex);
  })
}

const cancelDelete = () =>{
  console.log("cancel");
  setAlert(false);
}

	return(
		<Fragment>
     		<Breadcrumb  data={breadcrumbItems} showVersion={true}  current={props.match.params.id}/>
			<Card className="mb-5  pb-2">
				<span className="mt-4 ml-3 d-flex">
					<h5>Project Group</h5>
					<a className="align-left pl-5" href={'/ProjectGroups/'+ props.match.params.id+'/edit'}>
						<span className="pe-7s-pen info-color"></span>
					</a> 
					<a className="coinName pl-2"
			          onClick={()=>deleteRow(props.match.params.id)}
			          rel="noopener noreferrer">
			          <span className="sub">
			            <span className="pe-7s-trash danger-color"></span>
			          </span>
			        </a>
			        <SweetAlert
				        warning
				        showCancel
				        show={Alert}
				        confirmBtnText="Yes, delete it!"
				        confirmBtnBsStyle="danger"
				        title="Are you sure?"
				        onConfirm={()=>confirmDelete()}
				        onCancel={()=>cancelDelete()}
				        focusCancelBtn
				    >
				        You will not be able to recover this imaginary file!
				    </SweetAlert>
				</span>
			</Card>
			<div className="card-box mb-5 card">
				<div className="no-gutters row">
					<div className="p-4 col-xl-12">
						<div className="divider-v divider-v-lg"></div>
						<div className="d-flex align-items-center justify-content-between">
							<div>
								<b>Name</b>
								<div className="text-black-50">Project Group Name</div>
							</div>
							<div className="font-weight-bold text-black-50">
								<b>{fields.projectGroupName}</b>
							</div>
						</div>
						<div className="divider my-3"></div>
						<div className="d-flex align-items-center justify-content-between">
							<div>
								<b>Code</b>
								<div className="text-black-50">Project Group Code</div>
							</div>
							<div className="font-weight-bold text-black-50">
								<b>{fields.projectGroupCode}</b>
							</div>
						</div>
						<div className="divider my-3"></div>
						<div className="d-flex align-items-center justify-content-between">
							<div>
								<b>Desc</b>
								<div className="text-black-50">Project Group Desc</div>
							</div>
							<div className="font-weight-bold text-black-50">
								<b>{fields.projectGroupDesc}</b>
							</div>
						</div> 
					</div>
				</div>
			</div>
		</Fragment>
	);
}

const mapStateToProps = state => ({
   data: state.Projectgroup.data,
})

export default connect(mapStateToProps,{getProjectGroup,deleteProjectGroup})(withRouter(View));
