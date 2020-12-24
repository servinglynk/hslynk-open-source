import React, { Fragment, useEffect, useState } from 'react';
import { FormText, Form, Label, FormGroup, Input, Button, Card } from 'reactstrap';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
import clsx from 'clsx';
import { ToastContainer, toast } from 'react-toastify';
import { addProjectGroup } from '../../config/actions/Projectgroup'
import  Breadcrumb  from '../../layout-components/Breadcrumb'

const Create = (props) => {
  
  const [fields, setFields] = useState({skipuseridentifers: false});
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  const [toggleValue, setToggleValue] = useState(false);
  
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
  },[])

  const setValue = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setFields({
        ...fields,
        [name]: value
    });
  }

  const getToggleValue = (e) => {
    let toggle = !toggleValue;
    setToggleValue(toggle);
    setFields({
        ...fields,
        skipuseridentifers: toggle
    });
    console.log(fields);
  }

  const submitProjectGroup = () =>{
    const params = {
      projectGroup:{
        ...fields
      }
    };
    props.addProjectGroup('/projectgroups',{},params,'post').then((response)=>{
      if(response.status == '200'){
        toast.success("ProjectGroup added successfully")
        props.history.push('/ProjectGroups');
      }
    })
  }

  const cancelCall = () => {
    props.history.push('/ProjectGroups');
  }

 return (
    <Fragment>
      <Breadcrumb  data={breadcrumbItems} showVersion={true} current="create" />
      <Card className="card-box mb-5 p-3 ">
        <div className="my-3">
          <h6 className="font-weight-bold font-size-lg mb-1 text-black">
            Create ProjectGroup
          </h6>
          
        </div>
        <div className="">
          <Form>
            <FormGroup>
              <Label for="exampleEmail">Project Group Name</Label>
              <Input
                type="text"
                name="projectGroupName"
                id="projectGroupName"
                placeholder="Project Group Name"
                onChange={(e)=>setValue(e)}
                defaultValue={fields.projectGroupName}
              />
            </FormGroup>
            <FormGroup>
              <Label for="exampleText">Project Group Desc</Label>
              <Input 
                type="textarea"
                name="projectGroupDesc"
                id="projectGroupDesc"
                value={fields.projectGroupDesc}
                onChange={(e)=>setValue(e)}
              />
            </FormGroup>
            <FormGroup>
              <Label for="exampleText">Skip User Identifers</Label>
              <input
                className="react-switch-checkbox"
                id={`react-switch-new`}
                type="checkbox"
                defaultChecked={toggleValue}
                onChange={(e)=>getToggleValue(e)}
              />
              <label className={clsx('react-switch-label', {
                  'react-switch-on': toggleValue
                }) }
                htmlFor={`react-switch-new`}
              >
                <span className={`react-switch-button`} />
              </label>
            </FormGroup>
            <Button onClick={()=>cancelCall()} color="danger" className="mt-4 float-right">
              Cancel
            </Button>
            <Button className="mt-4 float-right mr-1 btn-normal" onClick={()=>submitProjectGroup()}>
              Add
            </Button>

          </Form>
        </div>
      </Card>
    </Fragment>
  );
}


const mapStateToProps = state => ({
   data: state.Projectgroup.data,
})

export default connect(mapStateToProps,{addProjectGroup})(withRouter(Create));