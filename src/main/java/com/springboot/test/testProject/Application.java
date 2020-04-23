package com.springboot.test.testProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/* @SpringBootApplication이 있는 위치부터 설정을 읽음 */
//@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication //스프링 부트의 자동설정, 스프링Bean 읽기/생성을 모두 자동 설정
public class Application { //해당 프로젝트의 메인 클래스며, 프로젝트 최상단에 위치해야함
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); //내장WAS 실행, 톰캣필요X jar로 실행
    }
}       
