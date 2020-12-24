import React, { Fragment, useState, useEffect } from 'react';

import { Form, Label, FormGroup, Input, Button, Card } from 'reactstrap';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
import clsx from 'clsx';
import { ToastContainer, toast } from 'react-toastify';

import { getProjectGroup, updateProjectGroup } from '../../config/actions/Projectgroup'
import  Breadcrumb  from '../../layout-components/Breadcrumb'

const Edit = (props) =>{
  const [fields, setFields] = useState(
      {
        projectGroupName:'',
        projectGroupDesc:'',
        skipuseridentifers: false
      }
    );
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
      props.getProjectGroup('/projectgroups/'+props.match.params.id,{},{},'get').then((response) => {
        console.log("response",response);
        setFields({
          projectGroupName:response.payload.projectGroupName,
          projectGroupDesc:response.payload.projectGroupDesc,
          skipuseridentifers: false
        });
        // setProjectGroups(response.data.projectgroups.projectGroups);
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
    props.updateProjectGroup('/projectgroups/'+props.match.params.id,{},params,'put').then((response)=>{
      if(response.status == '200'){
        toast.success("ProjectGroup updated successfully")
        props.history.push('/ProjectGroups');
      }
    })
  }

  const cancelCall = () => {
    props.history.push('/ProjectGroups');
  }

 return (
    <Fragment>
      <Breadcrumb  data={breadcrumbItems} showVersion={true}  current="edit"/>
      <Card className="card-box mb-5 p-3 ">
        <div className="my-3">
          <h6 className="font-weight-bold font-size-lg mb-1 text-black">
            Update ProjectGroup
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
                defaultValue={fields.projectGroupName}
                onChange={(e)=>setValue(e)}
              />
            </FormGroup>
            <FormGroup>
              <Label for="exampleText">Project Group Desc</Label>
              <Input type="textarea" name="projectGroupDesc" id="projectGroupDesc" defaultValue={fields.projectGroupDesc} onChange={(e)=>setValue(e)} />
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
            <Button color="danger" className="mt-4 float-right" onClick={()=>cancelCall()}>
              Cancel
            </Button>
            <Button className="mt-4 float-right mr-1 btn-normal" onClick={()=>submitProjectGroup()}>
              Update
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

export default connect(mapStateToProps,{getProjectGroup, updateProjectGroup})(withRouter(Edit));