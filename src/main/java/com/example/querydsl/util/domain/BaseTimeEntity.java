package com.example.querydsl.util.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime registerTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    protected void setDate() {
        this.registerTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
    }
}
