package com.example.springlvv.repository;

import com.example.springlvv.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> findByIdAndUserid(Long userid, Long id);
    List<Board> findAllBy();
    @Override
    Optional<Board> findById(Long Id);
}
