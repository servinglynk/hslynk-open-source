import React, { Fragment, useState, useEffect,useRef } from 'react';
import {Row, Col,Form, Label, FormGroup, Input, Button, Card } from 'reactstrap';
import { withRouter } from "react-router-dom";
import { connect } from 'react-redux';
import SweetAlert from 'react-bootstrap-sweetalert';
import { ToastContainer, toast } from 'react-toastify';
import {Typeahead} from 'react-bootstrap-typeahead'
import { getTrustedApp, updateTrustedApp,updateProjectGroup,getUpdatedProjectGroup ,deleteProjectGroup} from '../../config/actions/TrustedApps'
import { getProjectGroups } from '../../config/actions/Projectgroup'
import  Breadcrumb  from '../../layout-components/Breadcrumb'
const Edit = (props) =>{

  const ref = useRef();
  const [fields, setFields] = useState(
      {
        friendlyName:'',
 	      description:'',
	      status:'',
	      trustedAppProfileType:''
      }
    );
  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  const [projectGroup, setProjectGroup] = useState([]);
  const [selectedProjectGroup, setselectedProjectGroup] = useState([]);
  const [Alert,setAlert] = useState(false);
  const [groupId,setGroupId] = useState('')
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

  const updatedProjectGroup = [].concat(
    projectGroup.filter(projectobj => selectedProjectGroup.every(selectedProject => projectobj.projectGroupName !== selectedProject.projectGroupName)),
    selectedProjectGroup.filter(selectedProject => projectGroup.every(projectobj => selectedProject.projectGroupName !== projectobj.projectGroupName))
  );

  useEffect(() => {
      getBreadCrumbItems();
      let trustedApps = localStorage.getItem('trustedApps');
      let trustedApp = JSON.parse(trustedApps).filter(x => x.trustedAppId === props.match.params.id)[0];
      props.getTrustedApp('/trustedapps/'+props.match.params.id+'/projectgroups',{},{},'get').then((response) => {
        setFields({
          friendlyName:trustedApp.friendlyName,
          description:trustedApp.description,
          status: trustedApp.status,
          trustedAppProfileType: trustedApp.trustedAppProfileType
        });
      }).catch((ex) => {
        console.log('error', ex);
      })

      const params = {
        startIndex : 0,
        maxItems : 10
      };

      props.getProjectGroups('/projectgroups',{},params,'get').then((response) => {
        setProjectGroup(response.payload.projectGroups)
      }).catch((ex) => {
        console.log('error', ex);
      })

      props.getUpdatedProjectGroup(`/trustedapps/${props.match.params.id}/projectgroups`,{},params,'get').then((response) => {
      setselectedProjectGroup(response.payload.projectGroups)
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
  }

  const submitTrustedAPP = () => {
    const params = {
      trustedAppStatus:{
        ...fields
      }
    };
    props.updateTrustedApp('/trustedapps/'+props.match.params.id+'/approvaldecision',{},params,'post').then((response)=>{
      if(response.status == '200'){
        toast.success("Trusted App updated successfully")
        props.history.push('/TrustedApps');
      }
    })
  }

  const submitProjectGroup = () => {

    ref.current.clear()
    const params = {
      projectGroup:{
        projectGroupId:groupId
      }
    };

    props.updateProjectGroup(`/trustedapps/${props.match.params.id}/projectgroups`,{},params,'put').then((response)=>{
      if(response.status == '200'){
        toast.success("Project Group In Trusted App Updated successfully")
        props.getUpdatedProjectGroup(`/trustedapps/${props.match.params.id}/projectgroups`,{},params,'get').then((response) => {
          setselectedProjectGroup(response.payload.projectGroups)
          }).catch((ex) => {
            console.log('error', ex);
          })
      }
    })
  }

  const cancelCall = () => {
    props.history.push('/TrustedApps');
  }

  const handleGroupchange = (selectedData) => {
    selectedData.forEach(item => {
      setGroupId(item.projectGroupId)
    })
  }

const confirmDelete = () => {
  setAlert(false)
  props.deleteProjectGroup(`/trustedapps/${props.match.params.id}/projectgroups/${groupId}`,{},{},'delete').then((response) => {
    if(response.status == '200'){
        toast.success("Project Group Deleted successfully")
        const params = {
          startIndex : 0,
          maxItems : 10
        };

        props.getUpdatedProjectGroup(`/trustedapps/${props.match.params.id}/projectgroups`,{},params,'get').then((response) => {
          setselectedProjectGroup(response.payload.projectGroups)
          }).catch((ex) => {
            console.log('error', ex);
        })
        
    }
  }).catch((ex) => {
    console.log('error', ex);
  })
}

const deleteRow = (id) =>{
  setGroupId(id);
  setAlert(true); 
}

const cancelDelete = () =>{
  setAlert(false);
}

 return (
    <Fragment>
      <Breadcrumb  data={breadcrumbItems} showVersion={true}  current="edit"/>
      <Card className="card-box mb-5 p-3 ">
        <div className="my-3">
          <h6 className="font-weight-bold font-size-lg mb-1 text-black">
            Update Trusted App
          </h6>
        </div>
        <div className="">
          <Form>
            <FormGroup>
              <Label for="exampleEmail">Name</Label>
              <Input
                type="text"
                name="friendlyName"
                id="friendlyName"
                placeholder="Name"
                defaultValue={fields.friendlyName}
                onChange={(e)=>setValue(e)}
              />
            </FormGroup>
            <FormGroup>
              <Label for="exampleText">Description</Label>
              <Input type="textarea" name="description" id="description" defaultValue={fields.description} onChange={(e)=>setValue(e)} />
            </FormGroup>
            <FormGroup>
            <Label for="exampleText">Status</Label>
            <Input type="select" id="userinput5"  onChange={(e) => setValue(e)} name="status">
              <option value="" defaultValue="" disabled="">Select Status</option>
              <option  selected={fields.status === 'ACTIVE' ? 'ACTIVE' : ''}>ACTIVE</option>
              <option  selected={fields.status === 'SUBMITTED' ? 'SUBMITTED': ''}>SUBMITTED</option>
              <option  selected={fields.status === 'IN_DEVELOPMENT' ? 'IN_DEVELOPMENT' : ''}>IN_DEVELOPMENT</option>
            </Input>
            </FormGroup>
            <Button color="danger" className="mt-4 float-right" onClick={()=>cancelCall()}>
              Cancel
            </Button>
            <Button color="primary" className="mt-4 float-right mr-1 btn-normal" onClick={()=>submitTrustedAPP()}>
              Update
            </Button>
          </Form>
        </div>
      </Card>

      <Card className="card-box mb-5 p-3 ">
      <div className="my-3">
          <h6 className="font-weight-bold font-size-lg mb-1 text-black">
            Update Project Group
          </h6>
        </div>
        <Form >
          <Row>
          {selectedProjectGroup.length ?
            <Col lg="4">
              <Label><b>Project Group List</b></Label>
              <Card className="card-box mb-5">
                <ul className="list-group project-list">
                {selectedProjectGroup.map((item,i) => {
                  return(
                    <li className="list-group-item">
                    <div>
                      <span>{item.projectGroupName}</span>
                        <i className="pe-7s-trash mt-2 danger-color" onClick={() => deleteRow(item.projectGroupId)} ></i>
                      </div>
                    </li>
                  )
                })}
                </ul>
              </Card>
            </Col>
          :""}
          </Row>
          <FormGroup row className="typeahead-group">
            <Col>
              <Typeahead
                id="selections-example"
                labelKey="projectGroupName"
                multiple={false}
                onChange={(selectedData) => handleGroupchange(selectedData)}
                options={selectedProjectGroup ? updatedProjectGroup : projectGroup}
                placeholder="Choose a Project Group..."
                ref={ref}
              />
            </Col>
          </FormGroup>
          <Button color="danger" className="mt-4 float-right" onClick={()=>cancelCall()}>
            Cancel
          </Button>
          <Button color="primary" className="mt-4 float-right mr-1 btn-normal" onClick={()=>submitProjectGroup()}>
            Update
          </Button>
        </Form>
      </Card>
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
      <ToastContainer /> 
    </Fragment>
  );
}


const mapStateToProps = state => ({
   data: state.Projectgroup.data
})

export default connect(mapStateToProps,{getTrustedApp, updateTrustedApp,getProjectGroups,updateProjectGroup,getUpdatedProjectGroup,deleteProjectGroup})(withRouter(Edit));