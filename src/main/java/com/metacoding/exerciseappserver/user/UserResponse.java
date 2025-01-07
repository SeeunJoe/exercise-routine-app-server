package com.metacoding.exerciseappserver.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserResponse {

    public record DTO(Integer id, String username) {
        public DTO(User user) {
            this(user.getId(), user.getUsername());
        }
    }

    public record DetailDTO(Integer id, String username, String email, Integer weight, Integer height) {
        public DetailDTO(User user) {
            this(
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getWeight(),
                    user.getHeight()
            );
        }
    }

    // jwt는 service -> controller 넘어갈 때만 사용
    record LoginDTO(@JsonIgnore String accessToken, Integer id, String username) {
        LoginDTO(String accessToken, User user) {
            this(accessToken, user.getId(), user.getUsername());
        }
    }

    record AutoLoginDTO(Integer id, String username) {
        AutoLoginDTO(User user) {
            this(user.getId(), user.getUsername());
        }
    }
}