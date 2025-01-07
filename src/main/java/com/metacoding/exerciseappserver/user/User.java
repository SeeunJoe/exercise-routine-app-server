package com.metacoding.exerciseappserver.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    // nullable은 아무것도 작성하지 않을 시 true 가 기본값이기에 작성을 생략
    // 추후에 추가적인 제약 조건이 생기면 그때 괄호안에 제약조건 작성
    @Column()
    private Integer height = 0;

    @Column()
    private Integer weight = 0;

    @Builder
    public User(Integer id, String username, String password, String email, Integer height, Integer weight) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.height = height;
        this.weight = weight;
    }

    public void updatePassword(String password){
        this.password = password;
    }

}
