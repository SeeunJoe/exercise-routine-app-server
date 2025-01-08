package com.metacoding.exerciseappserver.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class JoinDTO {
        private String username;
        private String password;
        private String email;
        private Integer height;
        private Integer weight;
        User toEntity(String encPassword) {
            return User.builder()
                    .username(username)
                    .password(encPassword)
                    .email(email)
                    .height(height)
                    .weight(weight)
                    .build();
        }
    }

    @Data
    public static class LoginDTO {
        private String username;
        private String password;
    }

    @Data
    public static class PasswordUpdateDTO {
        private String password;
    }
}
