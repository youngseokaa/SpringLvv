package com.example.springlvv.controller;

import com.example.springlvv.dto.*;
import com.example.springlvv.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/c/write/{id}")
    public CommentResponseDto Commentwrite(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest request) {
        return commentService.commentwrite(id, commentRequestDto, request);
    }


    @PutMapping("/c/revise/{id}")
    public CommentResponses Commentrevise(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest request) {
        return commentService.commentrevise(id, commentRequestDto, request);
    }


    @DeleteMapping("/c/delete/{id}")
    public Map<String, Object> Commentdelete(@PathVariable Long id, HttpServletRequest request){
        return commentService.commentdelete(id,request);
    }
}
