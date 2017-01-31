#!/bin/bash

USERNAME=$1
PASSWD=$2

echo "create local unix user"
useradd $USERNAME
usermod -G hadoop $USERNAME

echo "add user to ldap"

LDAP_HOST=$3
LDAP_PORT=$4
ROOTDN="cn=admin,dc=us-west-2,dc=compute,dc=internal"
LDAP_ADMIN_PASSWD=$5
LDIF="/tmp/$1.ldif"


echo  "dn: uid=$USERNAME,cn=hive,dc=us-west-2,dc=compute,dc=internal" > $LDIF
echo "objectclass: account" >> $LDIF
echo "objectclass: simpleSecurityObject" >> $LDIF
echo "objectclass: top" >> $LDIF
echo "uid: $USERNAME" >> $LDIF
echo "userpassword: $PASSWD" >> $LDIF


/usr/bin/ldapmodify -x -h $LDAP_HOST -p $LDAP_PORT -D "$ROOTDN" -w $LDAP_ADMIN_PASSWD -a -f $LDIF
rm -f $LDIF

echo "done"