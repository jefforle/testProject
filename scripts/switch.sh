#!/usr/bin/env bash
# 엔진엑스 프록시 설정 변경

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh

function switch_proxy() {
  IDLE_PORT=$(find_idle_port)

  echo "> 전환할 Port: $IDLE_PORT"
  echo "> Port 전환"
  echo "set \$service_url http://127.0.0.1:${IDLE_PORT};" | sudo tee /etc/nginx/conf.d/service-url.inc
  # 하나의 문장으로 만들어 파이프라인(|)으로 넘겨주기 위해 echo 사용

  echo "> 엔진엑스 Reload"
  sudo service nginx reload # restart와 다름
}