package com.springboot.test.testProject.service.posts;

import com.springboot.test.testProject.domain.posts.Posts;
import com.springboot.test.testProject.domain.posts.PostsRepository;
import com.springboot.test.testProject.web.dto.PostsListResponseDto;
import com.springboot.test.testProject.web.dto.PostsResponseDto;
import com.springboot.test.testProject.web.dto.PostsSaveRequestDto;
import com.springboot.test.testProject.web.dto.PostsUpdateRequestDto;
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
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id"+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

   // @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id"+ id));
        System.out.println(postsRepository.findById(id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new)
        //return postsRepository.findAllDesc().stream().map(posts -> new PostsListResponseDto(posts))
                                                    .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
    }

}
