package com.springboot.test.testProject.domain.posts;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)도 칼럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) //auditing기능 포함시킴
public abstract class BaseTimeEntity {

    @CreatedDate //Entity가 생성되어 저장될때 시간이 자동 저장됨
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity값이 변경할 떄 시간이 자동 저장됨
    private LocalDateTime modifiedDate;

}
