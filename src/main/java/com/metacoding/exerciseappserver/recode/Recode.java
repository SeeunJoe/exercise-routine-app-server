package com.metacoding.exerciseappserver.recode;

import com.metacoding.exerciseappserver.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "recode_tb")
public class Recode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private boolean isChecked;

    @Builder
    public Recode(Integer id, User user, LocalDateTime createdAt, boolean isChecked) {
        this.id = id;
        this.user = user;
        this.createdAt = createdAt;
        this.isChecked = isChecked;
    }

}

