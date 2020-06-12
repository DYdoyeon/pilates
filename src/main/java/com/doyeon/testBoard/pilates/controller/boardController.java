package com.doyeon.testBoard.pilates.controller;


import com.doyeon.testBoard.pilates.domain.result.ListResult;
import com.doyeon.testBoard.pilates.domain.result.ObjectResult;
import com.doyeon.testBoard.pilates.domain.entity.Post;
import com.doyeon.testBoard.pilates.domain.repository.BoardRepository;
import com.doyeon.testBoard.pilates.domain.result.ResultPrint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/qna")
@ResponseBody
@Slf4j
public class boardController {
    BoardRepository boardRepository;

    @Autowired
    boardController(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    // Write Post
    @PostMapping("/write")
    public ObjectResult callWriteForm (HttpServletResponse response,Post post) throws Exception {

        log.info(post.getCategory());
        boardRepository.save(post);
        return setObjectResult(response.getStatus(), "success", post);


    }


    // get List 한 개의 메소드로 할 수 있는 방법이 있지 않을까???
    // show "Q&A" list ("Q&A" Menu)
    @GetMapping("/list")
    public ListResult getPostList(HttpServletResponse response) throws Exception {

            return setListResult(response.getStatus(),"message",boardRepository.findAll());

        }

    // show "Q&A" list ("Q&A" Menu)
    @GetMapping("/list/{id}")
    public ObjectResult getPost(HttpServletResponse response,@PathVariable Long id) throws Exception {


            Optional<Post> optional = boardRepository.findById(id);

            if (!optional.isPresent())
                throw new Exception();

               return  setObjectResult(response.getStatus(),"success",optional.get());


    }

    // Delete Post
    @DeleteMapping("/list/{id}")
    public ListResult deletePost(HttpServletResponse response, @PathVariable String id) throws Exception {
        String[] idx = id.split(",");

            for (int i = 0; i < idx.length; i++) {
                Long index = Long.valueOf(idx[i]);
                Optional<Post> optional = boardRepository.findById(index);
                optional.ifPresent(selectPost ->
                        boardRepository.deleteById(Long.valueOf(index))
                );
            }
            return setListResult(response.getStatus(), "message", boardRepository.findAll());


        }
        // Update Post
        @PatchMapping("/list/{id}")
        public ObjectResult updatePost (HttpServletRequest request, HttpServletResponse response, @PathVariable Long id ) throws Exception {
               Optional<Post> optional = boardRepository.findById(id);

                optional.ifPresent(selectPost -> {

                    selectPost.setCategory(request.getParameter("category"));
                    selectPost.setContent(request.getParameter("content"));
                    selectPost.setDivision(request.getParameter("division"));
                    selectPost.setTitle(request.getParameter("title"));
                    selectPost.setUpdateTime(LocalDateTime.now());
                    boardRepository.save(selectPost);
                });
                // return null;
                return setObjectResult(response.getStatus(), "success", optional.get());

        }

      public ListResult setListResult(int code, String msg,  List<Post> posts){

            ListResult listResult = new ListResult();
            listResult.setCode(code);
            listResult.setMsg(msg);
            listResult.setObj(posts);

            return listResult;

        }

        public ObjectResult setObjectResult(int code, String msg, Post post) throws Exception{
            ObjectResult objectResult = new ObjectResult();

            objectResult.setCode(code);
            objectResult.setMsg(msg);
            objectResult.setObj(post);

            return objectResult;

        }


    }






