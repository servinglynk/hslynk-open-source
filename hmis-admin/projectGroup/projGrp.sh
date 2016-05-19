#!/bin/bash
DB=$1
ROLE=$DB"_role"
HIVE_CONFIG_DIR="/var/run/cloudera-scm-agent/process/`ls -alrt /var/run/cloudera-scm-agent/process | grep HIVESERVER2 | tail -1 | awk '{print $9}'`"

GENERATE_TICKET="kinit -k -v -t $HIVE_CONFIG_DIR/hive.keytab hive/ip-172-31-10-65.us-west-2.compute.internal@US-WEST-2.COMPUTE.INTERNAL"
$GENERATE_TICKET
CONNECT_CMD="jdbc:hive2://ip-172-31-10-65.us-west-2.compute.internal:10000/;principal=hive/ip-172-31-10-65.us-west-2.compute.internal@US-WEST-2.COMPUTE.INTERNAL"
beeline -u $CONNECT_CMD -hiveconf db_name=$DB -hiveconf db_role=$ROLE -f projGrp.hql