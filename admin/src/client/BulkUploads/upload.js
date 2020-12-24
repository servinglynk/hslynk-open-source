import React, { Fragment, useState,useEffect } from 'react';
import {Card,CardHeader,Form,FormGroup,Label,Input, Col, Button} from 'reactstrap'
import {connect} from 'react-redux'
import {addBulkUpload} from '../../config/actions/BulkUploads'
import { toast } from 'react-toastify';
import { withRouter } from 'react-router';
import  Breadcrumb  from '../../layout-components/Breadcrumb'
const BluckUpload = (props) =>  {

    const [breadcrumbItems, setBreadcrumbItems] = useState([]);
    const [year,setYear] = useState('')
    const [file,setfile] = useState('')
    console.log(props.data);
    const handleFileChange = (e) => {
        setfile(e.target.files[0])
        console.log(e.target.files[0]);
    }

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

      

    const handleYearChange = (e) => {
        setYear(e.target.value)
        console.log(e.target.value);
    }

    const submitBulkUpload =  () => {
        console.log(file.name);
        const formData =  new FormData()
        formData.append("file",file)
        const params = formData
         props.addBulkUpload(`/bulkupload/${year}`,{},params,'post').then((response)=>{
            console.log(response);
            if(response.status == '200'){
              toast.success("Bulk Upload successfully")
              props.history.push('/BulkUploads')
            }
          })
    }

    const cancelCall = () => {
        props.history.push('/BulkUploads');
      }


    return (
        <Fragment>
            <Breadcrumb  data={breadcrumbItems} showVersion={true} current="create" />
           <Card className="card-box mb-5 p-3">
            <div className="my-3">
                <h6 className="font-weight-bold font-size-lg mb-1 text-black">
                    HMIS Bulk Uploads
                </h6>
            </div>
                <Form>
                    <FormGroup row>
                        <Col sm={2}>
                            <Label >HMIS Bulk Uploads</Label>
                        </Col>
                        <Col sm={10}>
                            <Input type="file" onChange={(e) => handleFileChange(e)} />
                        </Col>
                    </FormGroup>
                    <FormGroup row>
                        <Col sm={2}>
                            <Label>Year</Label>
                        </Col>
                        <Col sm={2}>
                            <Input  type="select" value={year} onChange={(e) => handleYearChange(e)}> 
                                <option>Version/Year</option>
                                <option value={"401"}>4.0.1 - 2015</option>
                                <option value={"411"}>4.1.1 - 2016</option>
                                <option value={"51"}>5.0.1 - 2017</option>
                                <option value={"611"}>6.1.1 - 2018</option>
                                <option value={"612"}>6.1.2 - 2019</option>
                                <option value={"fy2020"}>fy2020 - 2020</option>
                            </Input>
                        </Col>
                    </FormGroup>
                    <Button onClick={()=>cancelCall()} color="danger" className="mt-4 float-right">
                        Cancel
                    </Button>
                    <Button className="mt-4 float-right mr-1 btn-normal" onClick={()=>submitBulkUpload()}>
                        Upload
                    </Button>
                </Form>
            </Card>
        </Fragment>
    );
}

const mapStateToProps = state => ({
    data: state.data,
 })


export default connect(mapStateToProps,{addBulkUpload})(withRouter(BluckUpload));