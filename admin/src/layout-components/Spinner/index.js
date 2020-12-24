import React, { Fragment } from "react";
import BounceLoader from "react-spinners/BounceLoader";
import { css } from "@emotion/core";
import { Row, Col } from "reactstrap";

const Spinner = (props) => {
	const override = css`
     display: block;
     margin: 0 auto;
     border-color: "#254b65";
   `;

   return (
      <Fragment>
         <Row>
           <Col className="sweet-loading mt-5 text-center " sm="12" md={{ size: 6, offset: 3 }}>
               <BounceLoader
                css={override}
                size={150}
                color={"#f4772e"}
                loading= {props.loading}
              />
              <span className="normal-color">Loading...</span>
            </Col>
         </Row>
         {/* Minimal statistics charts */}
      </Fragment>
   );
}

export default Spinner;