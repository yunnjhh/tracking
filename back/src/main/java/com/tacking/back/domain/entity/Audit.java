package com.tacking.back.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Audit {

    @Column(name = "registered_time", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime registeredAt;

    @Column(name = "modified_time")
    @LastModifiedDate
    private LocalDateTime modifiedAt;

}
