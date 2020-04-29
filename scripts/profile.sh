#!/usr/bin/env bash
# 쉘스크립트에서 사용할 공통 profile과 port 체크 로직

# 쉬고 있는 profile 찾기(real1이 사용 중이면 real2가 쉬고 있고, 반대면 real1이 쉬고 있음)
function find_idle_profile() {
    RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://localhost/profile) #현재 엔진엑스가 바라보는 스프링 부트가 정상 수행중인지 확인

    if [ ${RESPONSE_CODE} -ge 400 ] # 반환된 응답값(HttpStatus)가 400이상이면 오류로 보고
    then
      CURRENT_PROFILE=real2
    else
      CURRENT_PROFILE=$(curl -s http://localhost/profile)
    fi

    if [ ${CURRENT_PROFILE} == real1 ]
    then
      IDLE_PROFILE=real2 # 엔진엑스와 연결되지 않은 profile, 스프링 부트를 이 프로젝트로 연결하기 위한 반환
    else
      IDLE_PROFILE=real1
    fi
    echo "${IDLE_PROFILE}"

    # 쉬고 있는 profile의 port 찾기
    function find_idle_port() {
        IDLE_PROFILE=$(find_idle_profile)

        if [ ${IDLE_PROFILE} == real1 ]
        then
          echo "8081"
        else
          echo "8082"
        fi
    }
}