package com.springboot.test.testProject.web;

import com.springboot.test.testProject.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //1
public class HelloController {
    @GetMapping("/hello") //2
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}

/*
@RestController : 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 줌
                  예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다고 보면 됨
@GetMapping : HTTP Method인 Get요청을 받을 수 있는 API를 만들어 줌
             예전에는 @RequestMapping(method=RequestMethod.GET)으로 사용했음
              => /hello 요청이 오면 문자열 hello반환
@RequestParam : 외부에서 API로 넘긴 파라미터를 가져옴
                외부에서 name (@RequestParam("name"))이란 이름으로 넘긴 파라미터를
                메소드 파라미터 name (String name)으로 저장
 */