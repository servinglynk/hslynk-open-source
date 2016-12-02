#!/bin/bash
DB=$1
VERSION=$2
ROLE=$DB"_role"

HIVE_SERVER=$3
HIVE_USERNAME=$4
HIVE_PASSWORD=$5

CONNECT_CMD="jdbc:hive2://$HIVE_SERVER:10000/; $HIVE_USERNAME $HIVE_PASSWORD"

if [[ "$VERSION" == 2015 ]]; then
    beeline -u "$CONNECT_CMD" -hiveconf db_name=$DB -hiveconf db_role=$ROLE -f HiveSQLCreateTable_v2015.hql

elif [[ "$VERSION" == 2014 ]]; then
    beeline -u "$CONNECT_CMD" -hiveconf db_name=$DB -hiveconf db_role=$ROLE -f HiveSQLCreateTable.hql

else
    echo "[ERROR] unknown version $VERSION"
fi