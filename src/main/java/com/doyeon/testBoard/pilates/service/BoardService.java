package com.doyeon.testBoard.pilates.service;

import com.doyeon.testBoard.pilates.domain.entity.Post;
import com.doyeon.testBoard.pilates.domain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    BoardRepository boardRepository;
    @Autowired
    BoardService (BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public List<Post> test(){
        return boardRepository.findAll();
    }
}
