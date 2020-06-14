package com.doyeon.testBoard.pilates.service;

import com.doyeon.testBoard.pilates.domain.entity.Post;
import com.doyeon.testBoard.pilates.domain.repository.BoardRepository;
import com.doyeon.testBoard.pilates.domain.result.ListResult;
import com.doyeon.testBoard.pilates.domain.result.ObjectResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BoardService {
    BoardRepository boardRepository;
    @Autowired
    BoardService (BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public ResponseEntity<?> getAllPost(int status){

        return new ResponseEntity<>(
                ListResult.builder()
                        .code(status)
                        .msg("success")
                        .obj(boardRepository.findAll())
                        .build(), HttpStatus.OK
        );
    }

    public ResponseEntity<?> getPost(int status, Long id){
        return new ResponseEntity<>(
                ObjectResult.builder()
                        .code(status)
                        .msg("success")
                        .obj(boardRepository.findById(id))
                        .build(), HttpStatus.OK
        );
    }


    public ResponseEntity<?> writePost (int status,Post post){
        boardRepository.save(post);
        return new ResponseEntity<>(
                ObjectResult.builder()
                        .code(status)
                        .msg("success")
                        .obj("")
                        .build(), HttpStatus.OK
        );
    }

    // Update Post
    // Update Post
    public  ResponseEntity<?> updatePost (int status ,Post post) {

        boardRepository.update(post);

        return new ResponseEntity<>(
                ObjectResult.builder()
                        .code(status)
                        .msg("success")
                        .obj("")
                        .build(),HttpStatus.OK
        );

    }


    // Delete Post
    @DeleteMapping("/list/{id}")
    public ResponseEntity deletePost( int status ,Long id) throws Exception {
        boardRepository.delete(id);
        return new ResponseEntity<>(
                ObjectResult.builder()
                    .code(status)
                    .msg("success")
                    .obj("")
                    .build(),HttpStatus.OK
        );
    }
}
