import React from "react";
import { Link } from 'react-router-dom'
import { Breadcrumb, BreadcrumbItem } from 'reactstrap';
// import { CopyToClipboard } from 'react-copy-to-clipboard';
// import { Copy } from 'react-feather';

const Breadcrumbs = props => {
	console.log(props.data);
  	const capitalize = (s) => {
	  if (typeof s !== 'string') return ''
	  return s.charAt(0).toUpperCase() + s.slice(1)
	}	
	return (
		<div className="d-flex flex-column flex-md-row">
            <div className="flex-grow-1">
            	<Breadcrumb tag="nav" listTag="div" className="d-flex h-100 align-items-center">
                  {props.data ? props.data.map((item, index) =>
                        <BreadcrumbItem key={`breadcrumbs-${index}`} >
                            {
                               item.name.length > 20 ?
                                <>
                                    <Link to={item.link} ><span>{item.name.substr(0, 4) + '...' + item.name.substr(item.name.length - 4)}</span></Link>
                                </>
                                :
                                <Link to={item.link} >{item.name=='admin'? capitalize('dashboard'):capitalize(item.name)}</Link>
                            }
                        </BreadcrumbItem>
                    ) : ''
                    }
                    <BreadcrumbItem active className="showCopy">
                        {(props.current && props.current.indexOf("...") == -1) && props.current.length > 20 ?
                            <>
                                <span>{props.current.substr(0, 4) + '...' + props.current.substr(props.current.length - 4)} </span>
                            </>
                            :
                            <span >{capitalize(props.current)}</span>
                        }
                    </BreadcrumbItem>
                </Breadcrumb>
            </div>
        </div>
	);
}
export default Breadcrumbs;