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

export JAVA_OPTS="-Dlog4j.configuration=file:$dir/../resources/log4j.properties   -Xmx6g -XX:MaxPermSize=2048m-XX:GCTimeLimit=time-limit"
java -jar target/hmis-load-processor-v2020-2.0.jar
