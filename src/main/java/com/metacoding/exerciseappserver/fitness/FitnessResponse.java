package com.metacoding.exerciseappserver.fitness;

import com.metacoding.exerciseappserver.category.Category;
import lombok.Data;

public class FitnessResponse {



    @Data
    public static class FitnessDTO {
        private Integer fitnessId;
        private String fitnessName;
        private Integer categoryId;


        public FitnessDTO(Fitness fit) {
            this.fitnessId = fit.getId();
            this.fitnessName = fit.getFitnessName();
            this.categoryId = fit.getCategory().getId();

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
