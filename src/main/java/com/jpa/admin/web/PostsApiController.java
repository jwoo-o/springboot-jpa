package com.jpa.admin.web;

import com.jpa.admin.service.PostsService;
import com.jpa.admin.web.dto.PostsResposeDto;
import com.jpa.admin.web.dto.PostsSaveRequestDto;
import com.jpa.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){

        return postsService.save(requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResposeDto findById(@PathVariable Long id){

        return postsService.findById(id);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){

        return postsService.update(id,requestDto);
    }
}
