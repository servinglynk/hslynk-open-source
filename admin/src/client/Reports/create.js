import React, { Fragment, useEffect, useState } from 'react';
import { FormText, Form, Label, FormGroup, Input, Button, Card,Col, Row,CustomInput } from 'reactstrap';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
import clsx from 'clsx';
import { ToastContainer, toast } from 'react-toastify';
import {Typeahead} from 'react-bootstrap-typeahead'
import { addReport,getReportsProject,getCocCode } from '../../config/actions/Reports'
import  Breadcrumb  from '../../layout-components/Breadcrumb'

const Create = (props) => {

  console.log("reportCocLits",props.reportCocLits);
  const [fields, setFields] = useState({reportType: 'APR', reportLevel: 'PROJECT'});
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  const [toggleValue, setToggleValue] = useState(true);
  console.log(toggleValue);
  const [projectIds,setprojectIds] = useState(null)
  
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
    props.getReportsProject('v2020/v2/projects?maxItems=1000',{},params,'get').then((response) => {
      console.log("response",response);
    }).catch((ex) => {
      console.log('error', ex);
    })
  }

  const getCocCode = () => {
    const params = {
      startIndex : 0,
      maxItems : 30
    };
    props.getCocCode('/hmis-clientapi-v2020/rest/projects/projectcocs',{},params,'get').then((response) => {
      console.log("response",response);
    }).catch((ex) => {
      console.log('error', ex);
    })
  }

  useEffect(() => {
    getBreadCrumbItems();
    getProjects()
    getCocCode()
  },[])


  const getToggleValue = (e) => {
    let toggle = !toggleValue;
    setToggleValue(toggle);
    // setFields({
    //     ...fields,
    //     skipuseridentifers: toggle
    // });
    // console.log(fields);
  }

  const setValue = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setFields({
        ...fields,
        [name]: value
    });
  }

  const submit = () => {
    const params = {
      reportConfig:{
        ...fields,
        projectIds
      }
    };
    props.addReport('/reports',{},params,'post').then((response)=>{
      if(response.status == '200'){
        toast.success("Report added successfully")
        props.history.push('/Reports');
      }
    })
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

  const handleCocchange = (selectedData) => {
    console.log("handleChange ", selectedData)
    // const projectGroupID = []
    // selectedData.forEach(item => {
    //   projectGroupID.push(Object.assign({"projectId" : item.projectId}))
    // })
    // setprojectIds(projectGroupID)
    // console.log(projectGroupID);
  }


  const cancelCall = () => {
    props.history.push('/Reports');
  }

 return (
    <Fragment>
      <Breadcrumb  data={breadcrumbItems} showVersion={true} current="create" />
      <Card className="card-box mb-5 p-3 ">
        <div className="my-3">
          <h6 className="font-weight-bold font-size-lg mb-1 text-black">
            Create File Report
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
                  <Label for="userinput7">
                    Report Level:
                  </Label>
                      <Col>
                        <Row>
                          <Label>COC</Label>
                            <CustomInput type="switch" id="exampleCustomSwitch" name="customSwitch" defaultChecked={toggleValue} onChange={(e)=>getToggleValue(e)} />
                          <Label>PROJECT</Label>
                        </Row>
                      </Col>
            </FormGroup>
                  
            {toggleValue ?
            <FormGroup>
              <Label for="exampleEmail">Project</Label>
              <Typeahead
                id="selections-example"
                labelKey="projectName"
                multiple={true}
                onChange={(selectedData) => handleGroupchange(selectedData)}
                options={props.reportProjectLits}
                placeholder="Choose a Project..."
              />
            </FormGroup>
            :
            <FormGroup>
              <Label for="exampleEmail">Coc</Label>
              <Typeahead
                id="selections-example"
                labelKey="cocCode"
                multiple={false}
                onChange={(selectedData) => handleCocchange(selectedData)}
                options={props.reportCocLits}
                placeholder="Choose a COC..."
              />
            </FormGroup>
            }

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
   data: state.Reports.data,
   reportCocLits: state.Reports.reportCocLits,
   reportProjectLits: state.Reports.reportProjectLits,
})

export default connect(mapStateToProps,{addReport,getReportsProject,getCocCode})(withRouter(Create));