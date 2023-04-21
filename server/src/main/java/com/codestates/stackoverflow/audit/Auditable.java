package com.codestates.stackoverflow.audit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass // 부모 클래스(엔티티)에 필드를 선언하고 단순히 속성만 받아서 사용하고싶을 때 사용하는 방법
@EntityListeners(AuditingEntityListener.class) // @EntityListeners 는 엔티티를 DB에 적용하기 전, 이후에 커스텀 콜백을 요청할 수 있는 어노테이션
// 커스텀 콜백을 요청할 클래스를 지정해주면 되는데, Auditing 을 수행할 때는 JPA 에서 제공하는 AuditingEntityListener.class 를 인자로 넘기면 된다.
public abstract class Auditable {

    @CreatedDate // 해당 엔티티가 생성될 때, 생성하는 시각을 자동으로 삽입해준다.
    @Column(name = "CommentRegistDate", updatable = false)
    private LocalDateTime commentRegistDate;

    @LastModifiedDate //해당 엔티티가 수정될 때, 수정하는 시각을 자동으로 삽입해준다.
    @Column(name = "CommentModifyDate")
    private LocalDateTime commentModifyDate;

}
