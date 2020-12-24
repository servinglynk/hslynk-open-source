import React, { useEffect, Fragment, useState } from "react";
import { Row, Col } from "reactstrap";
import { withRouter, Link } from "react-router-dom";
import { connect } from 'react-redux';
import BounceLoader from "react-spinners/BounceLoader";
import { css } from "@emotion/core";
// import { toast } from "react-toastify";
import queryString from 'query-string';
import { getToken } from '../../config/actions/Auth'

const Redirect = (props) => {
   useEffect(() => {
      const parsed = queryString.parse(props.location.search);
      let code = parsed.code;
      //API call to get token for loggedin client
      localStorage.setItem('session_token','null');
      if(code){
         props.getToken(code).then((response) => {
             localStorage.setItem('session_token', response.token)
         }).catch((ex) => {
                  console.log('error', ex);
            })
      }
     
      const intervalId = setInterval(() => {
            if (localStorage.getItem('session_token') != "null" && localStorage.getItem('session_token') != null ) {
               clearInterval(intervalId);
               props.history.push('/dashboard'); // redirect to dashboard page
            }
         }, 1000)
      
   }, []);

   const override = css`
     display: block;
     margin: 0 auto;
     border-color: "#3b3e66";
   `;

   return (
      <Fragment>
         <Row>
           <Col className="sweet-loading mt-5" sm="12" md={{ size: 6, offset: 3 }}>
               <BounceLoader
                css={override}
                size={150}
                color={"#f4772e"}
                loading= "true"
              />
            </Col>
         </Row>
         {/* Minimal statistics charts */}
      </Fragment>
   );
}

const mapStateToProps = state => ({
   pagination: state.token,
})

export default connect(mapStateToProps,{getToken})(withRouter(Redirect));
