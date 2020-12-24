import React, { Fragment, useState, useEffect } from 'react';
import { Card } from 'reactstrap';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
import SweetAlert from 'react-bootstrap-sweetalert';
import { ToastContainer, toast } from 'react-toastify';
import { getUser , deleteUser} from '../../config/actions/Users'
import  Breadcrumb  from '../../layout-components/Breadcrumb'

const View = (props) => {
 const [fields, setFields] = useState({
 	firstName:'',
 	lastName:'',
	username:'',
	emailAddress:'',
    profileName: '',
    status:''
 });
 const [Alert,setAlert] = useState(false);
 const [userId,setUserId] = useState('');
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);

	useEffect(() => {
		getBreadCrumbItems();
	    props.getUser('/accounts/'+props.match.params.id,{},{},'get').then((response) => {
	        console.log("response",response);
	        setFields({
	          firstName:response.payload.firstName,
	          lastName:response.payload.lastName,
	          username:response.payload.username,
	          emailAddress:response.payload.emailAddress,
              profileName : response.payload.profile.profileName,
              status:response.payload.status
	        });
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
	setUserId(id);
	setAlert(true);
  }
  
  const confirmDelete = () => {
	setAlert(false);
	props.deleteUser('/accounts/'+userId,{},{},'delete').then((response) => {
	  if(response.status==200){
		  toast.success("User was deleted successfully")
		  props.history.push('/Users');
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
					<h5>{fields.firstName}</h5>
					&nbsp;&nbsp;&nbsp;
					<a className="coinName btn-normal btn btn-secondary" href={'/Users/'+ props.match.params.id+'/edit'}>
						Edit
					</a> 
					<a className="coinName ml-2 btn btn-danger"
			          onClick={()=>deleteRow(props.match.params.id)}
			          rel="noopener noreferrer">
			          <span className="sub">
			            Delete
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
								<b>First Name</b>
							</div>
							<div className="font-weight-bold text-black-50">
								<b>{fields.firstName}</b>
							</div>
						</div>
						<div className="divider my-3"></div>
						<div className="d-flex align-items-center justify-content-between">
							<div>
								<b>Last Name</b>
							</div>
							<div className="font-weight-bold text-black-50">
								<b>{fields.lastName}</b>
							</div>
						</div>
						<div className="divider my-3"></div>
						<div className="d-flex align-items-center justify-content-between">
							<div>
								<b>Username</b>
							</div>
							<div className="font-weight-bold text-black-50">
								<b>{fields.username}</b>
							</div>
						</div> 
						<div className="divider my-3"></div>
                        	<div className="d-flex align-items-center justify-content-between">
							<div>
								<b>Email Address</b>
							</div>
							<div className="font-weight-bold text-black-50">
								<b>{fields.emailAddress}</b>
							</div>
						</div> 
						<div className="divider my-3"></div>
                        <div className="d-flex align-items-center justify-content-between">
							<div>
								<b>Profile</b>
							</div>
							<div className="font-weight-bold text-black-50">
								<b>{fields.profileName}</b>
							</div>
						</div> 
					</div>
				</div>
			</div>
		</Fragment>
	);
}

const mapStateToProps = state => ({
   data: state.Users.data,
})

export default connect(mapStateToProps,{getUser, deleteUser})(withRouter(View));
