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

    @Column(length = 20, unique = true)
    private String day;

    @Column(nullable = false)
    private Integer set;

    @Column(nullable = false)
    private Integer repeat;

    @Column(nullable = false)
    private Integer weight;

    @Builder
    public Plan(Integer id, User user, Category category, String day, Integer set, Integer repeat, Integer weight) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.day = day;
        this.set = set;
        this.repeat = repeat;
        this.weight = weight;
    }

}
