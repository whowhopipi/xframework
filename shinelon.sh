SRC_PATH=/home/Bonny/workspace/work/GIT/xframework/xframework-boot
REPO_PATH=/home/Bonny/workspace/work/GIT/xframework/maven

cd ${REPO_PATH}
git pull

cd ${SRC_PATH}
mvn clean package install deploy -DskipTests -DaltDeploymentRepository=git-repo::default::file:E:/Workplace/GIT/xframework/maven

if [[ $? -gt 0 ]]; then
  exit 1
fi

cd ${REPO_PATH}

git add *
git commit -m "sync"
git push

