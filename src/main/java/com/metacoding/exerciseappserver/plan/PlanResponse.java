package com.metacoding.exerciseappserver.plan;

import lombok.Data;

import java.util.List;


public class PlanResponse {

    // 요일 별 운동 계획 리스트 DTO
    @Data
    public static class PlanOfDayDTO {
        Integer id;
        Integer userId;
        Integer fitnessId;
        String fitnessName;
        String bodyPart;
        Integer setCount;
        Integer repeatCount;

        public PlanOfDayDTO(Plan plan) {
            this.id = plan.getId();
            this.userId = plan.getUser().getId();
            this.fitnessId = plan.getFitness().getId();
            this.fitnessName = plan.getFitness().getFitnessName();
            this.bodyPart = plan.getFitness().getCategory().getName();
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

    public record DetailPlanDTO(Integer id, String day ,String fitnessName, String fitnessImgUrl, String fitnessContent, Integer exerciseSet, Integer repeat, Integer weight) {
        public DetailPlanDTO(Plan plan) {
            this(
                    plan.getId(),
                    plan.getDayOfWeek(),
                    plan.getFitness().getFitnessName()!= null ? plan.getFitness().getFitnessName() : "Unknown Fitness",
                    plan.getFitness().getImageUrl()!= null ? plan.getFitness().getImageUrl() : "",
                    plan.getFitness().getContent()!= null ? plan.getFitness().getContent() : "",
                    plan.getRepeat(),
                    plan.getExerciseSet(),
                    plan.getWeight()
            );
        }
    }

    @Data
    public static class UpdatePlanDTO {
        private Integer id;
        private Integer exerciseSet;
        private Integer repeat;
        private Integer weight;


        public UpdatePlanDTO(Plan plan) {
            this.id = plan.getId();
            this.exerciseSet = plan.getExerciseSet();
            this.repeat = plan.getRepeat();
            this.weight = plan.getWeight();
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
