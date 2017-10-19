# HSLynk Human Services Data Warehouse
All subdirectories in this repository contain HSLynk microservice code.

Our issue tracker and wiki is in a separate repo (https://github.com/servinglynk/hmis-lynk-open-source-docs), to keep the code repo lean.

## Prerequisites

- Node: https://nodejs.org/en/
	- Preferred way to install: https://github.com/creationix/nvm
- Maven: https://maven.apache.org/install.html
- Eclipse or any IDE: http://www.eclipse.org/downloads/eclipse-packages/

## How to Run on local machine

Maker a local copy `database.properties` with the below conifg
```
app.jndi.name=jdbc/multischema
db.driver=org.postgresql.Driver

db.url=jdbc:postgresql://localhost:POSTGRE_PORT/hmis
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

v2015   (You need to run this if you plan to load data in the 2017 schema) 
 /hmis-model-v2017/build.xml
  replace <pathelement location="/Users/sdolia/.m2/repository/org/postgresql/postgresql/9.3-1101-jdbc41/postgresql-9.3-1101-jdbc41.jar"/>
 to wherever you have <pathelement location="MAVEN_HOME/org/postgresql/postgresql/9.3-1101-jdbc41/postgresql-9.3-1101-jdbc41.jar"/>
 
run setupDB2017
```

#### Deploy steps
- Open server.xml in your tomcat and add the below line.
  <Resource auth="Container" driverClassName="org.postgresql.Driver" factory="org.apache.commons.dbcp.BasicDataSourceFactory" initialSize="50" logAbandoned="true" maxActive="100" maxIdle="50" maxWait="60000" minIdle="50" name="jdbc/hmisdb" password="" removeAbandoned="true" removeAbandonedTimeout="30" testWhileIdle="true" type="javax.sql.DataSource" url="jdbc:postgresql://localhost:5432/hmis" username="postgres" validationQuery="SELECT 1"/>
- Deploy microservices you want in eclipse or any IDE.
