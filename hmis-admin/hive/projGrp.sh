#!/usr/bin/env bash
GENERATE_TICKET="kinit -k -v -t /var/run/cloudera-scm-agent/process/98-hive-HIVESERVER2/hive.keytab hive/ip-172-31-10-65.us-west-2.compute.internal@US-WEST-2.COMPUTE.INTERNAL"
$GENERATE_TICKET
CONNECT_CMD="jdbc:hive2://ip-172-31-10-65.us-west-2.compute.internal:10000/;principal=hive/ip-172-31-10-65.us-west-2.compute.internal@US-WEST-2.COMPUTE.INTERNAL"
beeline -u $CONNECT_CMD -hiveconf db_name=$1 -f projGrp.hql