import React, { Fragment } from 'react';

import { PageTitle } from '../../layout-components';

import { ExampleWrapperSimple } from '../../layout-components';
import FormsLayoutBasic from '../../example-components/FormsLayout/FormsLayoutBasic';
import FormsLayoutGrids from '../../example-components/FormsLayout/FormsLayoutGrids';
export default function FormsLayout() {
  return (
    <Fragment>
      <PageTitle
        titleHeading="Layout"
        titleDescription="Build whatever layout you need with our modular user interface framework."
      />

      <ExampleWrapperSimple sectionHeading="Basic">
        <FormsLayoutBasic />
      </ExampleWrapperSimple>
      <ExampleWrapperSimple sectionHeading="Grids">
        <FormsLayoutGrids />
      </ExampleWrapperSimple>
    </Fragment>
  );
}
