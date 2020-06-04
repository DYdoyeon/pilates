package com.doyeon.testBoard.pilates.domain.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class User {

    @Id
    private String id;
    private String name;
    private String gender;
    private Date birthday;
    private Integer membership_remain;
    private String membership_type;
}
