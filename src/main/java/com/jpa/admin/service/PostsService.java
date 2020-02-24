package com.jpa.admin.service;

import com.jpa.admin.domain.posts.Posts;
import com.jpa.admin.domain.posts.PostsRepository;
import com.jpa.admin.web.dto.PostsListResposeDto;
import com.jpa.admin.web.dto.PostsResposeDto;
import com.jpa.admin.web.dto.PostsSaveRequestDto;
import com.jpa.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;


    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }

    public PostsResposeDto findById(Long id) {

        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResposeDto(entity);
    }
    @Transactional(readOnly = true)
    public List<PostsListResposeDto> findAllDesc(){

        return postsRepository.findAllDesc().stream().map(PostsListResposeDto::new).collect(Collectors.toList());
    }
}
