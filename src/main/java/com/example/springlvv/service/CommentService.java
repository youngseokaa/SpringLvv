package com.example.springlvv.service;

import com.example.springlvv.dto.BoardResponseDto;
import com.example.springlvv.dto.CommentRequestDto;
import com.example.springlvv.dto.CommentResponseDto;
import com.example.springlvv.dto.CommentResponses;
import com.example.springlvv.entity.Board;
import com.example.springlvv.entity.Comment;
import com.example.springlvv.entity.User;
import com.example.springlvv.jwt.JwtUtil;
import com.example.springlvv.repository.BoardRepository;
import com.example.springlvv.repository.CommentRepository;
import com.example.springlvv.repository.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class CommentService {

    final private JwtUtil jwtUtil;
    final private CommentRepository commentRepository;
    final private UserRepository userRepository;
    final private BoardRepository boardRepository;


    public CommentResponseDto commentwrite(Long id, CommentRequestDto commentRequestDto, HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);
        Claims claims;
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                claims = jwtUtil.getUserInfoFromToken(token);

            } else {
                throw new IllegalArgumentException("token Error");
            }
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            Board board = boardRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("게시글이 존재하지 않습니다")
            );
            Comment comment = commentRepository.saveAndFlush(new Comment(commentRequestDto, board, user));
            return new CommentResponseDto(id, comment);
        }
        return null;
    }


    public BoardResponseDto commentrevise(Long id, CommentRequestDto commentRequestDto, HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);
        Claims claims;
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                claims = jwtUtil.getUserInfoFromToken(token);

            } else {
                throw new IllegalArgumentException("token Error");
            }
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            Comment comment = commentRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("댓글이 존재 하지 않습니다")
            );
                new CommentResponses(user,commentRequestDto);

        }
        return  new BoardResponseDto();
//
//        public Map<String, Object> commentdelete (Long id, HttpServletRequest request){
//
//        }
    }
}

