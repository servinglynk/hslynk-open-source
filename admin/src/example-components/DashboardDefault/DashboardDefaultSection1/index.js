import React, { Fragment } from 'react';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { Row, Col, CardBody, Card, Button } from 'reactstrap';

import Chart from 'react-apexcharts';
export default function LivePreviewExample() {
  const chart30Options = {
    chart: {
      toolbar: {
        show: false
      },
      sparkline: {
        enabled: true
      }
    },
    dataLabels: {
      enabled: false
    },
    colors: ['#3c44b1'],
    stroke: {
      color: '#4191ff',
      curve: 'smooth',
      width: 4
    },
    xaxis: {
      crosshairs: {
        width: 1
      }
    },
    yaxis: {
      min: 0
    },
    legend: {
      show: false
    }
  };
  const chart30Data = [
    {
      name: 'Customers',
      data: [47, 38, 56, 24, 45, 54, 38, 47, 38, 56, 24, 56, 24, 65]
    }
  ];

  const chart31Options = {
    chart: {
      toolbar: {
        show: false
      },
      sparkline: {
        enabled: true
      }
    },
    dataLabels: {
      enabled: false
    },
    colors: ['#f4772e'],
    stroke: {
      color: '#4191ff',
      curve: 'smooth',
      width: 3
    },
    xaxis: {
      crosshairs: {
        width: 1
      }
    },
    yaxis: {
      min: 0
    },
    legend: {
      show: false
    }
  };
  const chart31Data = [
    {
      name: 'Sales',
      data: [47, 38, 56, 24, 45, 54, 38, 47, 38, 56, 24, 56, 24, 65]
    }
  ];

  return (
    <div>   </div>
  );
}
