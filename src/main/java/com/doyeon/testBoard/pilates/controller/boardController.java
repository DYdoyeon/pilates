package com.doyeon.testBoard.pilates.controller;


import com.doyeon.testBoard.pilates.domain.entity.Post;
import com.doyeon.testBoard.pilates.domain.repository.BoardRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class boardController {

    @Autowired
    private BoardRepository boardRepository;


    // click "Write" Button
    @GetMapping(value="/qna/write")
    public String callWriteForm(){
        return "board/write.html";
    }

    // show "Q&A" list ("Q&A" Menu)
    @GetMapping(value="/qna")
    public List<Post> getList(){
        return boardRepository.findAll();
    }




}

