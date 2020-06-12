package com.doyeon.testBoard.pilates.domain.entity;


import lombok.*;
import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userNo;

    // @UniqueElements
    private String id;
    private String name;
    private String gender;
    private Date birthday;
    private String phoneNumber;
    private Integer membership_remain;
    private String membership_type;

 //   @OneToMany(fetch = FetchType.LAZY)
  //  @JoinColumn(name = "postNo")
  //  private Collection<Post> postNo;

  //  @OneToMany(fetch = FetchType.LAZY)
  //  @JoinColumn(name = "commentNo")
 //   private Collection<Comment> comment;

}
