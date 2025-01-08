package com.metacoding.exerciseappserver.plan;

import com.metacoding.exerciseappserver.category.Category;
import com.metacoding.exerciseappserver.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "plan_tb")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Column(length = 20)
    private String dayOfWeek;

    @Column(nullable = false)
    private Integer exerciseSet;

    @Column(nullable = false)
    private Integer repeat;

    @Column(nullable = false)
    private Integer weight;

    @Builder
    public Plan(Integer id, User user, Category category, String dayOfWeek, Integer exerciseSet, Integer repeat, Integer weight) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.dayOfWeek = dayOfWeek;
        this.exerciseSet = exerciseSet;
        this.repeat = repeat;
        this.weight = weight;
    }

}
