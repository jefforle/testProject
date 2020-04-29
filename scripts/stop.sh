#!/usr/bin/env bash
#기존 엔진엑스에 연결되어 있진 않지만 실행중인 스프링 부트 종료

ABSPATH=$(readlink -f $0) # 현재 stop.sh의 절대 경로
ABSDIR=$(dirname $ABSPATH) # 디렉토리 경로
source ${ABSDIR}/profile.sh # source: 일종의 import (profile.sh의 여러 function 사용 가능)

IDLE_PORT=$(find_idle_port)

echo "> $IDLE_PORT 에서 구동 중인 애플리케이션 pid 확인"
IDLE_PID=$(lsof -ti tcp:${IDLE_PORT})

if [ -z ${IDLE_PID} ]
then
  echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -15 $IDLE_PID"
  kill -15 ${IDLE_PID}
  sleep 5
fi