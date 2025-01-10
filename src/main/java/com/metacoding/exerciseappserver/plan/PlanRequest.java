package com.metacoding.exerciseappserver.plan;

import lombok.Data;

public class PlanRequest {

    @Data
    public static class UpdatePlanDTO {
        private Integer id; // planId
        private Integer exerciseSet;
        private Integer repeat;
        private Integer weight;
    }
}
