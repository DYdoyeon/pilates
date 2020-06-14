package com.doyeon.testBoard.pilates.domain.repository;


import com.doyeon.testBoard.pilates.domain.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface BoardRepository  {

  List<Post> findAll();
  Post findById(Long id);
  void save(Post post);
  void update(Post post);
  void delete(Long id);
}
