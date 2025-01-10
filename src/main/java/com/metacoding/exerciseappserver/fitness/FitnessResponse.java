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
}
