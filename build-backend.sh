#!/usr/bin/env bash

version=`awk '/<version>[^<]+<\/version>/{gsub(/<version>|<\/version>/,"",$1);print $1;exit;}' pom.xml`  # 读取版本号
echo "building version "${version}" ..."
rm backend/target/*.jar
mvn install
