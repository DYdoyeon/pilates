package com.doyeon.testBoard.pilates.controller;


import com.doyeon.testBoard.pilates.domain.entity.Post;
import com.doyeon.testBoard.pilates.domain.result.ListResult;
import com.doyeon.testBoard.pilates.domain.result.ObjectResult;
import com.doyeon.testBoard.pilates.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/qna")
@ResponseBody
@Slf4j
public class BoardController {

    BoardService boardService;

    @Autowired
    BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllPost(HttpServletResponse response) {

        return boardService.getAllPost(response.getStatus());
    }


    @GetMapping("/list/{id}")
    public ResponseEntity<?> getPost(HttpServletResponse response, @PathVariable Long id) {
        return boardService.getPost(response.getStatus(), id);
    }

    @PostMapping("/write")
    public ResponseEntity<?> writePost(HttpServletResponse response, @RequestBody Post post) {
        return boardService.writePost(response.getStatus(), post);
    }

    @PatchMapping("/list")
    public ResponseEntity<?> updatePost(HttpServletResponse response, @RequestBody Post post) throws Exception {
        return boardService.updatePost(response.getStatus(), post);
    }

    // Delete Post
    @DeleteMapping("/list/{id}")
    public ResponseEntity<?> deletePost(HttpServletResponse response, @PathVariable Long id) throws Exception {
        return boardService.deletePost(response.getStatus(), id);
    }
}
