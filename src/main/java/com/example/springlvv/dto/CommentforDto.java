package com.example.springlvv.dto;

import com.example.springlvv.entity.Board;
import com.example.springlvv.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.cert.CertPath;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentforDto {
    private String comment;
    private Long id;
    private String title;
    private String content;
    private Long userid;
    private String Username;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    CommentforDto(Comment comment, Board board){
        this.comment = comment.getComment();
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.userid = board.getUserid();
        this.Username = board.getUser().getUsername();
        this.createAt = board.getCreatedAt();
        this.updateAt = board.getModifiedAt();
    }
}
