package com.youngjun.jpa.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // MyBatis = DAO (DB Layer 접근자)
    // <Entity 클래스. PK 타입> : CRUD 메소드 자동 생성

}
