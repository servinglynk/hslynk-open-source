import React, { Fragment, useState, useEffect } from 'react';
import {Form, Label, FormGroup, Input, Button, Card ,CustomInput} from 'reactstrap';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
import { getUser, updateUser } from '../../config/actions/Users'
import  Breadcrumb  from '../../layout-components/Breadcrumb'
import { ToastContainer, toast } from 'react-toastify';
import { getProjectGroups } from '../../config/actions/Projectgroup'
import { getRole,getProfile } from '../../config/actions/Users'

const Edit = (props) => {
  const [fields, setFields] = useState(
      {
        firstName:'',
        lastName:'',
        newPassword:'',
        confirmNewPassword:'',
        status:''
      }
    );
  const [projectGroup,setProjectGroup] = useState([]) 
  const [selectedProjectGroup,setselectedProjectGroup] = useState({})
  const [selectedprofile,setselectedprofile] = useState({})
  const [selectedrole,setSelectedRole] = useState({}) 
  console.log("selectedrole",selectedrole);
  const [groupId,setGroupId] = useState('')
  const [roleId,setRoleId] = useState('')
  const [profileId,setProfileId] = useState('')
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);

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

  useEffect(() => {
      getBreadCrumbItems();
      props.getUser('/accounts/'+props.match.params.id,{},{},'get').then((response) => {
        console.log("response",response);
        setselectedProjectGroup(response.payload.projectGroup)
        setSelectedRole(response.payload.roles)
        setselectedprofile(response.payload.profile)
        setFields({
          firstName:response.payload.firstName,
          lastName:response.payload.lastName,
          status:response.payload.status
        });
      }).catch((ex) => {
        console.log('error', ex);
      })

      const params = {
        startIndex : 0,
        maxItems : 10
      };

      props.getProjectGroups('/projectgroups',{},params,'get').then((response) => {
        console.log("response",response);
        setProjectGroup(response.payload.projectGroups);
      }).catch((ex) => {
        console.log('error', ex);
      })

      props.getRole('/roles',{},params,'get').then((response) => {
        console.log("response",response);
      }).catch((ex) => {
        console.log('error', ex);
      })
  
      props.getProfile('/profiles',{},params,'get').then((response) => {
        console.log("response",response);
      }).catch((ex) => {
        console.log('error', ex);
      })

  }, []);

   const setValue = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setFields({
        ...fields,
        [name]: value
    });
    console.log("fields",fields);
  }

  const submitUser = () =>{
    const params = {
      account:{
        ...fields,
        role : {
          id: roleId
        },
        projectGroup : {
          projectGroupId : groupId
        },
        profile : {
          id : profileId
        }
      }
    };
    props.updateUser('/accounts/'+props.match.params.id,{},params,'put').then((response)=>{
      if(response.status == '200'){
        toast.success("User updated successfully")
        props.history.push('/Users');
      }
    })
  }

  const updatePassword = () =>{
    const params = {
      passwordChange:{
        ...fields
      }
    };
    props.updateUser('/accounts/'+props.data.list.username+'/passwordupdate',{},params,'put').then((response)=>{
      if(response.status == '200'){
        toast.success("User updated successfully")
        props.history.push('/Users');
      }
    })
  }

  const activateUser = () =>{
    const params = {
      account:{
        ...fields
      }
    };
    props.updateUser('/accounts/'+props.match.params.id+'/activate',{},params,'put').then((response)=>{
      if(response.status == '200'){
        toast.success("User updated successfully")
        props.history.push('/Users');
      }
    })
  }

  const cancelCall = () => {
    props.history.push('/Users');
  }

  const handleGroupchange = (id) => {
    setGroupId(id)
    setselectedProjectGroup('')
  }

  const handleRolechange = (id) => {
    setSelectedRole('')
    setRoleId(id)
  }

  const handleProfilechange = (id) => {
      setselectedprofile('')
      setProfileId(id)
  }

 return (
    <Fragment>
      <Breadcrumb  data={breadcrumbItems} showVersion={true}  current="edit"/>
      <Card className="card-box mb-5 p-3 ">
          <Form>
            <div className="my-3">
              <h6 className="font-weight-bold font-size-lg mb-1 text-black">
                Update User
              </h6>
            </div>
              <FormGroup>
                <Label for="exampleEmail">First Name</Label>
                <Input
                  type="text"
                  name="firstName"
                  id="firstName"
                  placeholder="First Name"
                  defaultValue={fields.firstName}
                  onChange={(e)=>setValue(e)}
                />
              </FormGroup>
              <FormGroup>
                <Label for="exampleText">Last Name</Label>
                <Input
                  type="text"
                  name="lastName"
                  id="lastName"
                  placeholder="Last Name"
                  defaultValue={fields.lastName}
                  onChange={(e)=>setValue(e)}
                />
              </FormGroup>
              <FormGroup>
              <Label for="exampleText">Status</Label>
                  <Input type="select" id="userinput6" onChange={(e) => setValue(e)} name="status" >
                    <option  selected={fields.status == 'ACTIVE' ? 'ACTIVE' : ''} >ACTIVE</option>
                    <option  selected={fields.status  == 'DELETED' ? 'DELETED': ''}>DELETED</option>
                    <option  selected={fields.status  == 'PENDING' ? 'PENDING' : ''}>PENDING</option>
                  </Input>
            </FormGroup>

            <FormGroup>
            <Label for="selections-group">Project Group</Label>
              <Input type="select" name="projectId" value={selectedProjectGroup.projectGroupId}  onChange={(e) => handleGroupchange(e.target.value)}> 
                {projectGroup.map((project) => {
                  return(
                  <option value={groupId == selectedProjectGroup.projectGroupId ? selectedProjectGroup.projectGroupId : project.projectGroupId}>{project.projectGroupName}</option>
                  )
                })}
              </Input>
            </FormGroup>
            
            <FormGroup>
            <Label for="selections-group">Role</Label>
              <Input type="select"  value={selectedrole.id} onChange={(e) => handleRolechange(e.target.value)}> 
                {props.role.map((role) => {
                  return(
                  <option  value={roleId == selectedrole.id ? selectedrole.id : role.id}>{role.roleName}</option>
                  )
                })}
              </Input>
            </FormGroup>

            <FormGroup>
            <Label for="selections-group">Profile</Label>
              <Input type="select" name="profileId"  value={selectedprofile.id}   onChange={(e) => handleProfilechange(e.target.value)}> 
                {props.profile.map((Profile) => {
                  return(
                  <option  value={profileId == selectedprofile.id ? selectedprofile.id : Profile.id}>{Profile.profileName}</option>
                  )
                })}
              </Input>
            </FormGroup>
            
            <Button color="danger" className="mt-4 float-right" onClick={()=>cancelCall()}>
              Cancel
            </Button>
            <Button color="primary" className="mt-4 float-right mr-1 btn-normal" onClick={()=>submitUser()}>
              Update
            </Button>
           {fields.status === 'PENDING' ?
             <>
            <Button color="primary" className="mt-4 float-right mr-1 btn-normal" onClick={()=>activateUser()}>
              Activate
            </Button>
            </>
            : ""
          }
          </Form>
      </Card>
      { fields.status === 'ACTIVE' ? 
      <>
      <Card className="card-box mb-5 p-3 ">
        <div className="my-3">
          <h6 className="font-weight-bold font-size-lg mb-1 text-black">
            Update Password
          </h6>
        </div>
        <div className="">
        <Form>
        <FormGroup>
              <Label for="exampleText">Password</Label>
              <Input
                type="password"
                name="newPassword"
                id="newPassword"
                placeholder="newPassword"
                defaultValue={fields.newPassword  }
                onChange={(e)=>setValue(e)}
              />
            </FormGroup>
        <FormGroup>
              <Label for="exampleText">Confirm Password</Label>
              <Input
                type="password"
                name="confirmNewPassword"
                id="confirmNewPassword"
                placeholder="Confirm Password"
                defaultValue={fields.confirmNewPassword}
                onChange={(e)=>setValue(e)}
              />
            </FormGroup>
            <Button color="danger" className="mt-4 float-right" onClick={()=>cancelCall()}>
              Cancel
            </Button>
            <Button color="primary" className="mt-4 float-right mr-1 btn-normal" onClick={()=>updatePassword()}>
              Update
            </Button>
            </Form>
        </div>
      </Card>
      </>
      : ""
    }
    </Fragment>
  );
}


const mapStateToProps = state => ({
   data: state.Users.data,
   role: state.Users.role,
   profile: state.Users.profile,
})

export default connect(mapStateToProps,{getUser, updateUser,getProjectGroups,getProfile,getRole})(withRouter(Edit));