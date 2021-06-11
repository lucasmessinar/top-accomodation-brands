#!/bin/sh

APP_PATH="application"
JAR=$(echo ${APP_PATH}/*jar)
echo ${JAR}
java -jar ${JAR}
