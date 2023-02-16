package com.example.springlvv.dto;


import com.example.springlvv.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CommentResponses {

    private String Username;
    private String comment;

    public CommentResponses(User user, CommentRequestDto commentRequestDto) {
        this.Username = user.getUsername();
        this.comment = commentRequestDto.getContents();
    }

}