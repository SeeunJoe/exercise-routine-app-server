package com.metacoding.exerciseappserver.plan;

import com.metacoding.exerciseappserver.fitness.Fitness;
import com.metacoding.exerciseappserver.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;


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
    private Fitness fitness;

    @Column(length = 20)
    private String dayOfWeek;

    @Column(nullable = false)
    private Integer exerciseSet;

    @Column(nullable = false)
    private Integer repeat;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private boolean fitnessCheck = false;

    @Builder
    public Plan(Integer id, User user, Fitness fitness, String dayOfWeek, Integer exerciseSet, Integer repeat, Integer weight) {
        this.id = id;
        this.user = user;
        this.fitness = fitness;
        this.dayOfWeek = dayOfWeek;
        this.exerciseSet = exerciseSet;
        this.repeat = repeat;
        this.weight = weight;
    }

    public void updatePlan(Integer exerciseSet, Integer repeat, Integer weight, Boolean fitnessCheckStatus) {
        if (exerciseSet != null) {
            this.exerciseSet = exerciseSet;
        }
        if (repeat != null) {
            this.repeat = repeat;
        }
        if (weight != null) {
            this.weight = weight;
        }
        if (fitnessCheckStatus != null) {
            this.fitnessCheck = fitnessCheckStatus;
        }

    }

    public boolean getFitnessCheckStatus() {
        return fitnessCheck;
    }
}
