package com.example.springlvv.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponseDto {
    private String msg = "회원가입 성공";
    private int statusCode = 200;
}
