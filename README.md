[![Build Status](https://builds.hmislynk.com/buildStatus/icon?job=Build-hmis-master)](https://builds.hmislynk.com/view/HMIS%20Build/job/Build-hmis-master/)
# HSLynk Human Services Data Warehouse
All subdirectories in this repository contain HSLynk microservice code.
Our issue tracker and wiki is in a separate repo (https://github.com/servinglynk/hmis-lynk-open-source-docs), to keep the code repo lean.

## Prerequisites

- Node: https://nodejs.org/en/
	- Preferred way to install: https://github.com/creationix/nvm
- Maven: https://maven.apache.org/install.html
- Eclipse or any IDE: http://www.eclipse.org/downloads/eclipse-packages/

## How to Run on local machine

Make a local copy `database.properties` with the below config in /hmis-base-model/src/main/resources
```
app.jndi.name=jdbc/multischema
db.driver=org.postgresql.Driver

db.url=jdbc:postgresql://localhost:POSTGRES_PORT/hmis
db.username=postgres
db.password=


hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
hibernate.show_sql=true
entitymanager.packages.to.scan=com.servinglynk.hmis.warehouse.entity
hibernate.default.schema=base
# change this indexing location value to point to your local system path (the value below is setup for the server)
solr.search.indexing.location=/usr/share/hmisindexing
db.initsize=10
db.maxactive=100
db.minidle=20
db.maxidle=20
db.maxwait=60000
#Also adding some more properties
```

```
git clone https://github.com/servinglynk/hmis-lynk-open-source.git
cd hmis-lynk-open-source
mvn clean install -DskipTests
```

Note: if you wish to run the unit tests, remove "-DskipTests" from the mvn command above,

## Deploy instructions

Tomcat is used to deploy this app.

#### First time steps

- Create database:
```
Open Eclipse and navigate to
Base Schema
/hmis-base-model/build.xml
 replace <pathelement location="/Users/sdolia/.m2/repository/org/postgresql/postgresql/9.3-1101-jdbc41/postgresql-9.3-1101-jdbc41.jar"/>
 to wherever you have <pathelement location="MAVEN_HOME/org/postgresql/postgresql/9.3-1101-jdbc41/postgresql-9.3-1101-jdbc41.jar"/>

run setupDB
    MasterData
    SSN_decrypt

v2014   (You need to run this if you plan to load data in the 2014 schema)
 /hmis-model-v2014/build.xml
  replace <pathelement location="/Users/sdolia/.m2/repository/org/postgresql/postgresql/9.3-1101-jdbc41/postgresql-9.3-1101-jdbc41.jar"/>
 to wherever you have <pathelement location="MAVEN_HOME/org/postgresql/postgresql/9.3-1101-jdbc41/postgresql-9.3-1101-jdbc41.jar"/>

run setupDB2014

v2015   (You need to run this if you plan to load data in the 2015 schema)
 /hmis-model-v2015/build.xml
  replace <pathelement location="/Users/sdolia/.m2/repository/org/postgresql/postgresql/9.3-1101-jdbc41/postgresql-9.3-1101-jdbc41.jar"/>
 to wherever you have <pathelement location="MAVEN_HOME/org/postgresql/postgresql/9.3-1101-jdbc41/postgresql-9.3-1101-jdbc41.jar"/>



run setupDB2015

v2016  (You need to run this if you plan to load data in the 2016 schema)
 /hmis-model-v2016/build.xml
  replace <pathelement location="/Users/sdolia/.m2/repository/org/postgresql/postgresql/9.3-1101-jdbc41/postgresql-9.3-1101-jdbc41.jar"/>
 to wherever you have <pathelement location="MAVEN_HOME/org/postgresql/postgresql/9.3-1101-jdbc41/postgresql-9.3-1101-jdbc41.jar"/>

run setupDB2016

v2017 (You need to run this if you plan to load data in the 2017 schema)
 /hmis-model-v2017/build.xml
  replace <pathelement location="/Users/sdolia/.m2/repository/org/postgresql/postgresql/9.3-1101-jdbc41/postgresql-9.3-1101-jdbc41.jar"/>
 to wherever you have <pathelement location="MAVEN_HOME/org/postgresql/postgresql/9.3-1101-jdbc41/postgresql-9.3-1101-jdbc41.jar"/>

run setupDB2017
```
Git Eclipse Maven Howto:
	Below is an example showing how to import Maven projects from the GitHub

	In this example:
	Git repository:https://github.com/hserv
	Project: coordinated-entry
	Sub project


	Open Eclipse
	File => Import
	Git => Projects from Git => Next
		HiLight Clone URI => Next	
		
		URI:https://github.com/hserv/coordinated-entry
		Host;github.com
		Repository Path:/hserv/coordinated-entry
		
		Connection
		Protocol https
		
		Authentication 
		User:
		Password:
		
		=> Next
		
		Select survey_global_project
		->Next
		
		Local Destination
		
		Directory
		c:/Users/xxxx/git/coordinated-entry
		
		
	Select import Wizard
		Click Maven 
		HiLight Existing Maven Projects
		=> Next
			
		Root Directory
		Browse to c:/Users/xxxx/git/coordinated-entry
		Check Project(s) to import from the list of projects (survey-api)
			=> Finish
			
		Projects have been imported and show in the Package Explorer window
		
		HiLight survey-api
		Right Click 
			HiLight Run As
				Maven install

#### Deploy steps
- Open server.xml in your tomcat and add the below line.
  <Resource auth="Container" driverClassName="org.postgresql.Driver" factory="org.apache.commons.dbcp.BasicDataSourceFactory" initialSize="50" logAbandoned="true" maxActive="100" maxIdle="50" maxWait="60000" minIdle="50" name="jdbc/hmisdb" password="" removeAbandoned="true" removeAbandonedTimeout="30" testWhileIdle="true" type="javax.sql.DataSource" url="jdbc:postgresql://localhost:5432/hmis" username="postgres" validationQuery="SELECT 1"/>
- Deploy microservices you want in eclipse or any IDE.

#### Project Description
- hmis-admin : <br />
  Hmis admin UI application for admin related activity for HMIS.
- hmis-authorization-service : <br />
	 Authorization service is a microservice which takes care of authentication and authorization and is a means to acquire authentication token whichn will be required to call other microservices.
- hmis-base-model : <br />
		Hmis base model is project which points to the base postgres schema.
- hmis-base-serialize : <br />
		Hmis base serialize contains pojos to serialize/de-serialize apis from the base base schema.
- hmis-user-service : <br />
		 Microservice containing apis providing hmis user,projects, organization, roles specific information.
- hmis-base-service : <br />
    Base service is a common service layer across all the hmis version specific schema and also contains service layer for the base service schema.
- hmis-chronichomeless-v2014:
     Background process to calculate Chronic homelessness in the 2014 schema.
- hmis-client-dedup 	: <br />
     Microservice to determine dedup client id from OPEN EMPI.
- hmis-client-deidentify : <br />
     Standalone java project to de-identify (remove) client specific information from the source file.
		 Client information like First Name, Last Name, DOB, SSN.
- hmis-clientapi-v2014 : <br />
     Microservice which has apis against the 2014 schema (HUD Version 4.0.1)
- hmis-clientapi-v2015 : <br />
	 	 Microservice which has apis against the 2015 schema (HUD Version 4.1.1)
- hmis-clientapi-v2016m : <br />
		 Microservice which has apis against the 2016 schema (HUD Version 5.1)
- hmis-clientapi-v2017   : <br />
		 Microservice which has apis against the 2017 schema (HUD Version 6.1)
- hmis-core-client   : <br />
     Common project across all the projects to communicate between microservices.	 			 	 			 			 
- hmis-core-common  : <br />
		Common library across all the projects containing basic utils and classes.
- hmis-developer-service  : <br />
    Microservice which contains apis to provision trusted app, developer company, developer service.
- hmis-global-household  : <br />
     Microservice containing apis related to global house hold.
- hmis-globalapi  : <br />
		 Microservice containing apis related to global house hold.
- hmis-hud-reports  : <br />
     Project which calculates/generates HUD APR reports.
- hmis-load-processor-v2014  : <br />
     Processes uploaded files agains the 2014 schema.
- hmis-load-processor-v2015  : <br />
		 Processes uploaded files agains the 2015 schema.
- hmis-load-processor-v2016  : <br />
		 Processes uploaded files agains the 2016 schema.
- hmis-load-processor-v2017	  : <br />
		Processes uploaded files agains the 2016 schema. 	
- hmis-model-v2014	 : <br />
     Java library containing Hibernate entities related to the 2014 data model.
- hmis-model-v2015  : <br />
		 Java library containing Hibernate entities related to the 2015 data model.
- hmis-model-v2016	: <br />
 		Java library containing Hibernate entities related to the 2016 data model.
- hmis-model-v2017  : <br />
     Java library containing Hibernate entities related to the 2017 data model. 	
- hmis-serialize-v2014  : <br />
     Java library containing pojos to serialize/de-serialize apis related to the 2014 database schema. HUD version 4.0.1.
- hmis-serialize-v2015  : <br />
		Java library containing pojos to serialize/de-serialize apis related to the 2015 database schema. HUD version 4.1.1.
- hmis-serialize-v2016  : <br />
		Java library containing pojos to serialize/de-serialize apis related to the 2016 database schema. HUD version 5.1.
- hmis-serialize-v2017  : <br />
		Java library containing pojos to serialize/de-serialize apis related to the 2017 database schema. HUD version 6.1.
- hmis-service-v2014  : <br />
		Java library containing spring service layer classes for 2014 apis and data model.
- hmis-service-v2015  : <br />
    Java library containing spring service layer classes for 2015 apis and data model.
- hmis-service-2016 : <br />
    Java library containing spring service layer classes for 2016 apis and data model.
- hmis-service-v2017  : <br />
    Java library containing spring service layer classes for 2017 apis and data model.
- hmis-s3-client  : <br />
     Java library containing code to connect to Amazon S3 for hmis.
- hmis-upload-service  : <br />
     Microservice to upload xml,zip or .7z files and to know the fetch the bulk uploads by status.
- hmis-notification-core     : <br />
     Java library to send email notification for functionalities like welcome email etc.
- hmis-notification-service  : <br />
		 Microservice which uses hmis-notification-core to send notifications.
- hmis-report-core  : <br />
	 	 Java library containing core report functionality.
- hmis-report-service  : <br />
	 	  Microservice which would be used to request a report for users. 				 		 		 
- sync-general  : <br />
     Sync process to sync data from postgres CES schema to HBASE.
- sync-years  : <br />
		 Sync process to sync data from postgres HMIS version specific schema to HBASE.
