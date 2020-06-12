package com.doyeon.testBoard.pilates.domain.repository;


import com.doyeon.testBoard.pilates.domain.entity.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoardRepository extends CrudRepository<Post, Long> {
   List<Post>  findAll();

}
