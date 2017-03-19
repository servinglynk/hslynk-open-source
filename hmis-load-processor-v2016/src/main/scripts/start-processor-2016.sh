#!/usr/bin/env bash
get_abs_script_path() {
pushd . >/dev/null
cd $(dirname $0)
dir=$(pwd)
popd  >/dev/null
}

get_abs_script_path
parentdir="$(dirname "$dir")"
logsFolder=$parentdir/logs
if [ ! -d "$logsFolder" ]; then
    echo "Creating logs folder"$logsFolder
    mkdir $logsFolder
fi

export CLASSPATH_PREFIX=$parentdir"/conf"

echo "Start sync"

export JAVA_OPTS="-Dlog4j.configuration=file:$dir/../resources/log4j.properties  -XX:MaxPermSize=1024m"
$dir/main-processor-2016.sh