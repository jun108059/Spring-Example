package com.youngjun.jpa.service.posts;

import com.youngjun.jpa.domain.posts.Posts;
import com.youngjun.jpa.domain.posts.PostsRepository;
import com.youngjun.jpa.web.dto.PostsSaveRequestsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestsDto requestsDto) {
        return postsRepository.save(requestsDto.toEntity()).getId();
    }

}
