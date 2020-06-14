package com.doyeon.testBoard.pilates.domain.result;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ObjectResult {
    public int code;
    public String msg;
    public Object obj;
  // generic으로 만들어보기
}
