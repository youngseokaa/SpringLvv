package com.example.springlvv.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private String msg = "로그인 성공";
    private int statusCode = 200;
}
