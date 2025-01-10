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

    @Data
    public static class ListByCateDTO {
        private Integer FitnessId;
        private String fitnessName;
        private Integer categoryId;
        private String categoryName;

        public ListByCateDTO(Fitness fit) {
            this.FitnessId = fit.getId();
            this.fitnessName = fit.getFitnessName();
            this.categoryId = fit.getCategory().getId();
            this.categoryName = fit.getCategory().getName();
        }
    }
    @Data
    public static class fitnessDTO{
        private Integer FitnessId;
        private String fitnessName;
        private String imageUrl;
        private String content;
        public fitnessDTO(Fitness fit) {
            this.FitnessId = fit.getId();
            this.fitnessName = fit.getFitnessName();
            this.imageUrl = fit.getImageUrl();
            this.content = fit.getContent();
        }
    }
}
