package com.doyeon.testBoard.pilates.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    @Id
    private Long commentsNo;


    private Long postNo;
    private String content;
    private String writer;
    private Date CreationTime;
    private Date UpdateTime;


}
