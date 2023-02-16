package com.example.springlvv.dto;

import com.example.springlvv.entity.Board;
import com.example.springlvv.entity.Comment;
import com.example.springlvv.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class BoardDto {

    private List<CommentforDto> comment;

    public BoardDto(Board board) {
        List<CommentforDto> list = new ArrayList<>();
        for(Comment comment : board.getComments()){
            list.add(new CommentforDto((comment),board));
        }
        this.comment = list;
    }

}