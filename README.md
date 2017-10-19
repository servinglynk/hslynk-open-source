# HSLynk Human Services Data Warehouse
All subdirectories in this repository contain HSLynk microservice code.

Our issue tracker and wiki is in a separate repo (https://github.com/servinglynk/hmis-lynk-open-source-docs), to keep the code repo lean.

## Prerequisites

- Node: https://nodejs.org/en/
	- Preferred way to install: https://github.com/creationix/nvm
- Maven: https://maven.apache.org/install.html
- Eclipse: http://www.eclipse.org/downloads/eclipse-packages/

## How to Run on local machine

Maker a local copy `settings.local.json` of the file `settings.json`

```
git clone https://github.com/servinglynk/hmis-lynk-open-source.git
cd hmis-lynk-open-source
mvn clean install -DskipTests
```


## Deploy instructions

Tomcat is used to deploy this app.

#### First time steps

- Create database: 
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

v2015   (You need to run this if you plan to load data in the 2017 schema) 
 /hmis-model-v2017/build.xml
  replace <pathelement location="/Users/sdolia/.m2/repository/org/postgresql/postgresql/9.3-1101-jdbc41/postgresql-9.3-1101-jdbc41.jar"/>
 to wherever you have <pathelement location="MAVEN_HOME/org/postgresql/postgresql/9.3-1101-jdbc41/postgresql-9.3-1101-jdbc41.jar"/>
 
run setupDB2017


#### Deploy steps

- Open eclipse and deploy the microservices you want on Tomcat.
