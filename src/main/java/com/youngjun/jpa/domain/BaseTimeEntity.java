package com.youngjun.jpa.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 이 클래스를 상속할 경우 아래 필드도 칼럼으로 인식함!
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 포함
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createDate; // Entity 생성되어 저장될 때 시간 자동 저장

    @LastModifiedDate
    private LocalDateTime modifiedDate; // 조회한 Entity 값 변경할 때 시간 자동 저장

}