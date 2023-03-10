package com.example.springlvv.dto;

import com.example.springlvv.entity.Board;
import com.example.springlvv.entity.Comment;
import com.example.springlvv.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private Long userid;
    private String Username;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.userid = board.getUserid();
        this.Username = board.getUser().getUsername();
        this.createAt = board.getCreatedAt();
        this.updateAt = board.getModifiedAt();
    }

}