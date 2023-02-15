package com.example.springlvv.repository;

import com.example.springlvv.entity.Board;
import com.example.springlvv.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}