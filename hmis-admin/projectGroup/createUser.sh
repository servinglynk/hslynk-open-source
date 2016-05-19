#!/bin/bash

USER=$1
PASSWORD=$2
KB_PRINC=$3
KB_PASSWD=$4

echo "create local unix user"
useradd $USER
usermod -G hadoop $USER

echo "add user to kerberos"
echo -n "$KB_PASSWD" | kinit $KB_PRINC
kadmin.local -q "addprinc -pw $PASSWORD $USER/tableau"
echo "done"
