import React, { Fragment, useEffect, useState } from 'react';
import { FormText, Form, Label, FormGroup, Input, Button, Card } from 'reactstrap';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
import clsx from 'clsx';
import { ToastContainer, toast } from 'react-toastify';
import {Typeahead} from 'react-bootstrap-typeahead'
import { addExport,getExportsProject } from '../../config/actions/Exports'
import  Breadcrumb  from '../../layout-components/Breadcrumb'

const Create = (props) => {
  
  console.log(props.exportProjectLits);
  const [fields, setFields] = useState({exportType: 'HMIS', exportLevel: 'PROJECT'});
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  const [toggleValue, setToggleValue] = useState(false);
  const [projectIds,setprojectIds] = useState(null)
  console.log(projectIds);
  
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

  const getProjects = () => {
    const params = {
      startIndex : 0,
      maxItems : 30
    };

    props.getExportsProject('v2020/v2/projects?maxItems=1000',{},params,'get').then((response) => {
      console.log("response",response);
    }).catch((ex) => {
      console.log('error', ex);
    })
  }

  useEffect(() => {
    getBreadCrumbItems();
    getProjects()
  },[])

  const setValue = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setFields({
        ...fields,
        [name]: value
    });
  }

  const submit = () =>{
    const params = {
      fileExport:{
        ...fields,
        projectIds
      }
    };
    props.addExport('/export',{},params,'post').then((response)=>{
      if(response.status == '200'){
        toast.success("Export added successfully")
        props.history.push('/Exports');
      }
    })
  }

  const cancelCall = () => {
    props.history.push('/Exports');
  }

  const handleGroupchange = (selectedData) => {
    console.log("handleChange ", selectedData)
    const projectGroupID = []
    selectedData.forEach(item => {
      projectGroupID.push(Object.assign({"projectId" : item.projectId}))
    })
    setprojectIds(projectGroupID)
    console.log(projectGroupID);
}

 return (
    <Fragment>
      <Breadcrumb  data={breadcrumbItems} showVersion={true} current="create" />
      <Card className="card-box mb-5 p-3 ">
        <div className="my-3">
          <h6 className="font-weight-bold font-size-lg mb-1 text-black">
            Create File Export
          </h6>
        </div>
        <div className="">
          <Form>
            <FormGroup>
              <Label for="exampleEmail">Name</Label>
              <Input
                type="text"
                name="name"
                id="name"
                placeholder="Name"
                onChange={(e)=>setValue(e)}
                defaultValue={fields.name}
              />
            </FormGroup>
            <FormGroup>
              <Label for="exampleText">Start Date</Label>
              <Input className="border-primary" 
              type="date" 
              max={new Date().toISOString().slice(0, 10)} 
              onChange={(e) => setValue(e)} 
              name="startDate" 
              id="startDate" />
            </FormGroup>
            <FormGroup>
              <Label for="exampleText">End Date</Label>
              <Input className="border-primary" 
              type="date" 
              max={new Date().toISOString().slice(0, 10)} 
              onChange={(e) => setValue(e)} 
              name="endDate" 
              id="endDate" />
            </FormGroup>

            <FormGroup>
              <Label for="exampleEmail">Project</Label>
              <Typeahead
                id="selections-example"
                labelKey="projectName"
                multiple={true}
                onChange={(selectedData) => handleGroupchange(selectedData)}
                options={props.exportProjectLits}
                placeholder="Choose a Project..."
              />
            </FormGroup>

            <Button onClick={()=>cancelCall()} color="danger" className="mt-4 float-right">
              Cancel
            </Button>
            <Button className="mt-4 float-right mr-1 btn-normal" onClick={()=>submit()}>
              Add
            </Button>
          </Form>
        </div>
      </Card>
    </Fragment>
  );
}


const mapStateToProps = state => ({
   data: state.Exports.data,
   exportProjectLits: state.Exports.exportProjectLits,
})

export default connect(mapStateToProps,{addExport,getExportsProject})(withRouter(Create));