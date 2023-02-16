package com.example.springlvv.entity;

import com.example.springlvv.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comment;


    @JoinColumn(name = "User_ID")
    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name= "BOARD_ID",nullable = false)
    private Board board;

    public Comment(CommentRequestDto commentRequestDto, Board board ,User user){
        this.comment = commentRequestDto.getContents();
        this.board = board;
        this.user = user;
    }

    public void update(CommentRequestDto commentRequestDto) {

    }
}
