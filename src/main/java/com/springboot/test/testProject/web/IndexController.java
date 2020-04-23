package com.springboot.test.testProject.web;

import com.springboot.test.testProject.config.auth.LoginUser;
import com.springboot.test.testProject.config.auth.dto.SessionUser;
import com.springboot.test.testProject.service.posts.PostsService;
import com.springboot.test.testProject.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

/* 1) httpSession.getAttribute("user")를 이용한 세션 저장

    @GetMapping("/")
    public String index(Model model){ //Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장
        model.addAttribute("posts", postsService.findAllDesc()); //(key, value), posts란 이름으로 model에 추가
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("memberName", user.getName());
        }
        return "index"; //index.mustache 호출
    }*/

/* 2) @LoginUser 을 이용한 세션 저장 */
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){ //Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장
        model.addAttribute("posts", postsService.findAllDesc()); //(key, value), posts란 이름으로 model에 추가
        if(user != null){
            model.addAttribute("memberName", user.getName());
        }
        return "index"; //index.mustache 호출
    }

    //글 등록 페이지
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    //글 수정 페이지
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}



