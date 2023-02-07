package com.blogapp.service.impl;

import com.blogapp.entities.Post;
import com.blogapp.payloab.PostDto;
import com.blogapp.repository.PostRepository;
import com.blogapp.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postrpo;

    public PostServiceImpl(PostRepository postrpo) {
        this.postrpo = postrpo;
    }

    @Override
    public PostDto createDto(PostDto postDto) {
        Post post=new Post();
        post.setName(postDto.getName());
        post.setSize(postDto.getSize());
        Post saveEntity = postrpo.save(post);
              PostDto dto=new PostDto();
              dto.setId(saveEntity.getId());
              dto.setName(saveEntity.getName());
              dto.setSize(saveEntity.getSize());
        return dto;
    }
}
