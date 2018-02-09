#!/bin/bash

BASE_DIR=$(dirname $(readlink -f $0))

SRC_PATH=${BASE_DIR}/xframework-boot
REPO_PATH=${BASE_DIR}/maven

cd ${REPO_PATH}
git pull

TMP_DIR=xframework-boot-maven

cd ${SRC_PATH}
mvn clean package install deploy -DskipTests -DaltDeploymentRepository=git-repo::default::file:///d:/${TMP_DIR}

if [[ $? -gt 0 ]]; then
  exit 1
fi

cp -rf /cygdrive/d/${TMP_DIR}/* ${REPO_PATH}
rm -rf /cygdrive/d/${TMP_DIR}

cd ${REPO_PATH}

git add *
git commit -m "新增资源库"
git push
