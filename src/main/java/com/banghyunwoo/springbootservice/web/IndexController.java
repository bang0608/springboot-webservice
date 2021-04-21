package com.banghyunwoo.springbootservice.web;

import com.banghyunwoo.springbootservice.config.auth.LoginUser;
import com.banghyunwoo.springbootservice.config.auth.dto.SessionUser;
import com.banghyunwoo.springbootservice.web.domain.user.User;
import com.banghyunwoo.springbootservice.web.dto.PostsResponseDto;
import com.banghyunwoo.springbootservice.web.service.posts.PostsService;
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

    @GetMapping("/")
    public String getIndexPage(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());

//        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        // @@LoginUser 애노테이션 생성 -> 파라미터 처리

        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto responseDto = postsService.findById(id);
        model.addAttribute("post", responseDto);

        return "posts-update";
    }
}
