#!/bin/bash

BASE_DIR=$(dirname $(readlink -f $0))

SRC_PATH=${BASE_DIR}/xframework-boot
REPO_PATH=${BASE_DIR}/maven

cd ${SRC_PATH}
mvn clean package install deploy -DskipTests -DaltDeploymentRepository=git-repo::default::file://${REPO_PATH}

