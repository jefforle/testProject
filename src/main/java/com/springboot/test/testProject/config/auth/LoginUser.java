package com.springboot.test.testProject.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //이 어노테이션이 생성될수 있는 위치지정
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
