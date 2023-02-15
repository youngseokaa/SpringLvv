package com.example.springlvv.dto;

import com.example.springlvv.entity.Comment;
import com.example.springlvv.entity.Timestamped;
import com.example.springlvv.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDto {

    private Long id;

    private String content;

    public CommentResponseDto(Long id, Comment comment){
        this.id = id;
        this.content = comment.getComment();
    }
}
