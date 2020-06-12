package com.doyeon.testBoard.pilates.domain.entity;

import lombok.*;
import lombok.experimental.Accessors;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.h2.engine.Database;
import org.h2.engine.Domain;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
@AllArgsConstructor
//@Accessors(chain = true)
//@EntityListeners(value = { AuditingEntityListener.class })
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postNo;


    private String category;

    @CreatedDate
    private LocalDateTime creationTime ;

    public Post(){
        this.creationTime = LocalDateTime.now();
    }

    public String title;

    public String content;

  //  @OneToOne(fetch = FetchType.LAZY)
  //  @JoinColumn(name = "userNo")

    public String writer;


    public int viewCount;

   // @UpdateTimestamp
    public LocalDateTime updateTime;

    public String division;

    //@OneToMany(fetch=FetchType.LAZY)
    //@JoinColumn( name="commentsNo")
   // private Collection<Comment> comment;
}
