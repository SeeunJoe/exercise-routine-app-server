package com.metacoding.exerciseappserver.plan;

import lombok.Data;

import java.util.List;


public class PlanResponse {

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
