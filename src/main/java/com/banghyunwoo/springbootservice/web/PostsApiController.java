package com.banghyunwoo.springbootservice.web;

import com.banghyunwoo.springbootservice.web.dto.PostsSaveRequestDto;
import com.banghyunwoo.springbootservice.web.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long update(@RequestBody PostsSaveRequestDto postsSaveRequestDto) {
        return postsService.save(postsSaveRequestDto);
    }

//    @PostMapping("/api/v1/posts")
//    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
//        return postsService.save(requestDto);
//    }
//
//
//    @DeleteMapping("/api/v1/posts/{id}")
//    public Long delete(@PathVariable Long id) {
//        postsService.delete(id);
//        return id;
//    }
//
//    @GetMapping("/api/v1/posts/{id}")
//    public PostsResponseDto findById(@PathVariable Long id) {
//        return postsService.findById(id);
//    }
//
//    @GetMapping("/api/v1/posts/list")
//    public List<PostsListResponseDto> findAll() {
//        return postsService.findAllDesc();
//    }
}
