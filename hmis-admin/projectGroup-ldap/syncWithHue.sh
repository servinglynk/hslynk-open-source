#!/usr/bin/env bash

export HUE_CONF_DIR="/var/run/cloudera-scm-agent/process/`ls -alrt /var/run/cloudera-scm-agent/process | grep HUE | tail -1 | awk '{print $9}'`"
export JAVA_HOME=/usr/lib/jvm/java-7-oracle-cloudera

export HUE_SECRET_KEY=hdfs

cd /opt/cloudera/parcels/CDH/lib/hue
build/env/bin/hue useradmin_sync_with_unix

echo "done"
