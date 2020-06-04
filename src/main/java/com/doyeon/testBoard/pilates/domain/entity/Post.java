package com.doyeon.testBoard.pilates.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue
    private Long postNo;

    private String category;
    private String title;
    private String content;
    private String writer;
    private int viewCount;

    private Date creationTime;
    private Date updateTime;
    private String division;

}
