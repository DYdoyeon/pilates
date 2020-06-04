package com.doyeon.testBoard.pilates.service;

import com.doyeon.testBoard.pilates.domain.entity.Post;
import com.doyeon.testBoard.pilates.domain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public void save(){

    }
    public List<Post> getList(){
        List<Post> list = boardRepository.findAll();
        return list;
    }
}
