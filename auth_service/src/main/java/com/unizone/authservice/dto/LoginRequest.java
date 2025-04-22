package com.unizone.authservice.dto;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String studentId;
    private String password;
}