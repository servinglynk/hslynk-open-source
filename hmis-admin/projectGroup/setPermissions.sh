#!/bin/bash

DB_ROLE=$1
GROUP=$2

HIVE_SERVER=$3

HIVE_USERNAME=$4
HIVE_PASSWORD=$5

CONNECT_CMD="jdbc:hive2://$HIVE_SERVER:10000/; $HIVE_USERNAME $HIVE_PASSWORD "
beeline -u "$CONNECT_CMD" -hiveconf db_role=$DB_ROLE -hiveconf group=$GROUP -f setPerm.hql
