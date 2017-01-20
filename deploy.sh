

SRC_PATH=/home/hujh/work/GIT/xframework/xframework-boot
REPO_PATH=/home/hujh/work/GIT/xframework/maven

cd ${SRC_PATH}
mvn clean package install deploy -DskipTests -DaltDeploymentRepository=git-repo::default::file:D:/Workplace/GIT/xframework/maven

if [[ $? -gt 0 ]]; then
  exit 1
fi

cd ${REPO_PATH}

git add *
git commit -m "新增资源库"
git push
