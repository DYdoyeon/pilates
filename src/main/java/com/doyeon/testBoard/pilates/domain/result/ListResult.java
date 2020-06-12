package com.doyeon.testBoard.pilates.domain.result;


import com.doyeon.testBoard.pilates.domain.entity.Post;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;


@Getter
@Setter
public class ListResult {
    public int code;
    public String msg;
    public List<Post> obj;

}
