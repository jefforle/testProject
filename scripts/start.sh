#!/usr/bin/env bash
# 배포할 신규버전 스프링 부트 프로젝트를 stop.sh로 종료한 profile로 실행

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh

REPOSITORY=/home/ec2-user/app/step3
PROJECT_NAME=testProject

echo "> Build 파일 복사"
echo "> cp $REPOSITORY/zip/*.jar $REPOSITORY/"

cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> 새 애플리케이션 배포"
JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

echo "> $JAR_NAME 에 실행권한 추가"

chmod +x $JAR_NAME

echo "> $JAR_NAME 실행"

IDLE_PRIFILE=$(find_idle_profile) # properties 파일을 가져옴

echo "> $JAR_NAME 를 profile=$IDLE_PRIFILE 로 실행합니다."
nohup java -jar \
  -Dspring.config.location=classpath:/application.properties,classpath:/application-$IDLE_PRIFILE.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
  -Dspring.profiles.active=$IDLE_PRIFILE \
  $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &
