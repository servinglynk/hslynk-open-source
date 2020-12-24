import React, { Fragment, useEffect, useState } from 'react';
import { FormText, Form, Label, FormGroup, Input, Button, Card } from 'reactstrap';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
import { addUser } from '../../config/actions/Users'
import  Breadcrumb  from '../../layout-components/Breadcrumb'
import { ToastContainer, toast } from 'react-toastify';
import { getProjectGroups } from '../../config/actions/Projectgroup'
import { getRole,getProfile } from '../../config/actions/Users'

const CreateUser = (props) => {
  
  const [fields, setFields] = useState([]);
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  const [projectGroup, setProjectGroup] = useState([]);
  const [selectedId,setSeletedId] = useState({ projectId:'',roleId:"",profileId:""})
  console.log("selectedId",selectedId);

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
  },[])

  const setValue = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setFields({
        ...fields,
        [name]: value
    });
  }

  const submitUser = () =>{
    const params = {
      account:{
        ...fields,
        role : {
          id: selectedId.roleId
        },
        projectGroup : {
          projectGroupId : selectedId.projectId
        },
        profile : {
          id : selectedId.profileId
        }
      }
    };
    props.addUser('/accounts',{},params,'post').then((response)=>{
      if(response.status == '200'){
        props.history.push('/Users');
      }
    })
  }

  const cancelCall = () => {
    props.history.push('/Users');
  }

  const handleIdchange = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setSeletedId({
      ...selectedId,
      [name]:value
    })
  }

 return (
    <Fragment>
      <Breadcrumb  data={breadcrumbItems} showVersion={true} current="create" />
      <Card className="card-box mb-5 p-3 ">
        <div className="my-3">
          <h6 className="font-weight-bold font-size-lg mb-1 text-black">
            Create User
          </h6>
        </div>
        <div className="">
          <Form>
            <FormGroup>
              <Label for="exampleEmail">First Name</Label>
              <Input
                type="text"
                name="firstName"
                id="firstName"
                placeholder="First Name"
                onChange={(e)=>setValue(e)}
                value={fields.firstName}
              />
            </FormGroup>
            <FormGroup>
              <Label for="exampleText">Last Name</Label>
              <Input
                type="text"
                name="lastName"
                id="lastName"
                placeholder="Last Name"
                value={fields.lastName}
                onChange={(e)=>setValue(e)}
              />
            </FormGroup>
            <FormGroup>
              <Label for="exampleText"> Username</Label>
              <Input
                type="text"
                name="username"
                id="username"
                placeholder="Username"
                value={fields.username}
                onChange={(e)=>setValue(e)}
              />
            </FormGroup>
            <FormGroup>
              <Label for="exampleText"> Email Address</Label>
              <Input
                type="text"
                name="emailAddress"
                id="emailAddress"
                placeholder="Email Address"
                value={fields.emailAddress}
                onChange={(e)=>setValue(e)}
              />
            </FormGroup>
            <FormGroup>
              <Label for="exampleText"> Password</Label>
              <Input
                type="password"
                name="password"
                id="password"
                placeholder="Password"
                value={fields.password}
                onChange={(e)=>setValue(e)}
              />
            </FormGroup>
            <FormGroup>
              <Label for="exampleText">Confirm Password</Label>
              <Input
                type="password"
                name="confirmPassword"
                id="confirmPassword"
                placeholder="Confirm Password"
                value={fields.repassword}
                onChange={(e)=>setValue(e)}
              />
            </FormGroup>

            <FormGroup>
            <Label for="selections-group">Project Group</Label>
              <Input type="select" name="projectId"  onChange={(e) => handleIdchange(e)} > 
              <option value="" disabled selected hidden>Select Project Group</option>
                {projectGroup.map((project) => {
                  return(
                  <option value={project.projectGroupId}>{project.projectGroupName}</option>
                  )
                })}
              </Input>
            </FormGroup>

            <FormGroup>
            <Label for="selections-group">Role</Label>
              <Input type="select"  name="roleId" onChange={(e) => handleIdchange(e)}> 
              <option value="" disabled selected hidden>Select Role</option>
                {props.role.map((role) => {
                  return(
                  <option value={role.id}>{role.roleName}</option>
                  )
                })}
              </Input>
            </FormGroup>

            <FormGroup>
            <Label for="selections-group">Profile</Label>
              <Input type="select"  name="profileId" placeholder="Choose a Profile..." onChange={(e) => handleIdchange(e)}> 
              <option value="" disabled selected hidden>Select Profile</option>
                {props.profile.map((Profile) => {
                  return(
                  <option value={Profile.id}>{Profile.profileName}</option>
                  )
                })}
              </Input>
            </FormGroup>
           
            <Button onClick={()=>cancelCall()} color="danger" className="mt-4 float-right">
              Cancel
            </Button>
            <Button className="mt-4 float-right mr-1 btn-normal" onClick={()=>submitUser()}>
              Add
            </Button>
          </Form>
        </div>
      </Card>
    </Fragment>
  );
}

const mapStateToProps = state => ({
   data: state.Users.data,
   role: state.Users.role,
   profile: state.Users.profile,
})

export default connect(mapStateToProps,{addUser,getProjectGroups,getRole,getProfile})(withRouter(CreateUser));