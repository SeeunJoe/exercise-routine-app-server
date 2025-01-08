package com.metacoding.exerciseappserver.fitness;

import lombok.Data;

public class FitnessResponse {
    @Data
    public static class ExerciseListDTO {
        private Integer FitnessId;
        private String fitnessName;
        private Integer categoryId;
        private String categoryName;

        public ExerciseListDTO(Fitness fitness) {
            this.FitnessId = fitness.getId();
            this.fitnessName = fitness.getFitnessName();
            this.categoryId = fitness.getCategory().getId();
            this.categoryName = fitness.getCategory().getName();
        }
    }
}
