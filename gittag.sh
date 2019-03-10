#!/bin/bash  
 VERSION_MODE=$1  
 ENV_TAG_PREFIX=v
 # "major": 1,  
 # "minor": 0,  
 # "revision": 0,  
 # "buildNumber": 1  
 if [ "$VERSION_MODE" = "" ] ; then  
      VERSION_MODE="buildNumber"  
 fi  
 cd /Users/sdolia/github/hmis-lynk-open-source  
 #get highest tag number  
 VERSION=`git describe --match "$ENV_TAG_PREFIX[0-9]*" --abbrev=0 --tags`  
 #replace . with space so can split into an array  
 VERSION_BITS=(${VERSION//./ })  
 #get number parts and increase last one by 1  
 VNUM1=${VERSION_BITS[0]}  
 if [ "$VNUM1" = "" ] ; then  
      VNUM1=0;  
 fi  
 VNUM2=${VERSION_BITS[1]}  
 if [ "$VNUM2" = "" ] ; then  
      VNUM2=0;  
 fi  
 VNUM3=${VERSION_BITS[2]}  
 if [ "$VNUM3" = "" ] ; then  
      VNUM3=0;  
 fi  
 
 case $VERSION_MODE in  
      "major")  
           VNUM1=$((VNUM1+1))  
           ;;  
      "minor")  
           VNUM2=$((VNUM2+1))  
           ;;  
      "revision")  
           VNUM3=$((VNUM3+1))  
           ;;
 esac  
 #create new tag  
 NEW_TAG="$VNUM1.$VNUM2.$VNUM3"  
 echo "Last tag version $VERSION New tag will be $NEW_TAG"  
 #get current hash and see if it already has a tag  
 GIT_COMMIT=`git rev-parse HEAD`  
 NEEDS_TAG=`git describe --contains $GIT_COMMIT 2>/dev/null`  
 echo "###############################################################"  
 #only tag if no tag already (would be better if the git describe command above could have a silent option)  
 if [ -z "$NEEDS_TAG" ]; then  
   echo "Tagged with $NEW_TAG (Ignoring fatal:cannot describe - this means commit is untagged) "  
   git tag -a $NEW_TAG -m "$VERSION_MODE"  
   git push --tags  
 else  
   echo "Current commit already has a tag $VERSION"  
 fi  
 echo "###############################################################"  

