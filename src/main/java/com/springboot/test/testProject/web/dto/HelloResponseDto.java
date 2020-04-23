package com.springboot.test.testProject.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //모든 final필드가 포함된 생성자 생성
public class HelloResponseDto {
    private final String name;
    private final int amount;

}
