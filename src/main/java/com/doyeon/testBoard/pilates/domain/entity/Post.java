package com.doyeon.testBoard.pilates.domain.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Accessors(chain = true)
//@EntityListeners(value = { AuditingEntityListener.class })
public class Post {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long postNo;
    private String category;

    private String content;
    private String title;
    private String writer;




}
