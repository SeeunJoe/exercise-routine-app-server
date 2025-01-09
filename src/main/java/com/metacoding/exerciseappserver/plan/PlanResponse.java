package com.metacoding.exerciseappserver.plan;

import lombok.Data;

import java.util.List;


public class PlanResponse {

    // 요일 별 운동 계획 리스트 DTO
    @Data
    public static class PlanOfDayOfWeekDTO {
        Integer id;
        Integer userId;
        Integer fitnessId;
        String fitnessName;
        String bodypart;
        Integer setCount;
        Integer repeatCount;

        public PlanOfDayOfWeekDTO(Plan plan) {
            this.id = plan.getId();
            this.userId = plan.getUser().getId();
            this.fitnessId = plan.getFitness().getId();
            this.fitnessName = plan.getFitness().getFitnessName();
            this.bodypart = plan.getFitness().getCategory().getName();
            this.setCount = plan.getExerciseSet();
            this.repeatCount = plan.getRepeat();
        }
    }

    @Data
    public static class UserWeekInfoDTO {

        List<WeekInformation> weekInfo;

        public UserWeekInfoDTO(List<WeekInformation> weekInfo) {
            this.weekInfo = weekInfo;
        }
    }
}


// TODO : 추후 아래 클래스를 적절한 위치로 이동
@Data
class WeekInformation {
    String dayOfWeek;

    List<String> fitnessNameList;

    WeekInformation(String dayOfWeek, List<String> fitnessNameList) {
        this.dayOfWeek = dayOfWeek;
        this.fitnessNameList = fitnessNameList;
    }
}
