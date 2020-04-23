package com.springboot.test.testProject.config.auth;

import com.springboot.test.testProject.config.auth.dto.SessionUser;
import com.sun.org.apache.bcel.internal.generic.LUSHR;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

/* @LoginUser 사용 설정
   조건에 맞는 메소드가 있다면 아래 지정한 값으로 해당 메소드의 파라미터로 넘길 수 있음 */
@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null; //파라미터에 @LoginUser 이 붙어있는지
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType()); //파라미터 클래스타입이 SessionUser.class 인지
        return isLoginUserAnnotation && isUserClass;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //resolveArgument() : 파라미터에 전달할 객체 생성
        return httpSession.getAttribute("user"); //세션에서 객체 가져와서 전달
    }
}
