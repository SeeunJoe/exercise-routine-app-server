package com.metacoding.exerciseappserver.plan;

import com.metacoding.exerciseappserver.fitness.Fitness;
import com.metacoding.exerciseappserver.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PlanRequest {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlanAddDTO {
        private Integer userId;
        private Integer fitnessId;
        private String dayOfWeek;
        private Integer exerciseSet;
        private Integer repeat;
        private Integer weight;

        Plan toEntity() {
            return Plan.builder().
                    user(User.builder().id(userId).build()).
                    fitness(Fitness.builder().id(fitnessId).build()).
                    dayOfWeek(dayOfWeek).
                    exerciseSet(exerciseSet).
                    repeat(repeat).
                    weight(weight).
                    build();
        }
    }
    @Data
    public static class UpdatePlanDTO {
        private Integer id; // planId
        private Integer exerciseSet;
        private Integer repeat;
        private Integer weight;
    }
}
