package com.metacoding.exerciseappserver.recode;

import lombok.Data;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class RecodeRequest {

    @Data
    public static class RecodeDTO {
        List<RecodeInformation> recodeInformationList;

        public RecodeDTO(List<RecodeInformation> recodeInformationList) {
            this.recodeInformationList = recodeInformationList;
        }
    }

    @Data
    public static class RecodeInformation {
        String date;
        boolean isChecked;

        public RecodeInformation(Recode recode) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.date = recode.getCreatedAt().format(formatter);
            this.isChecked = recode.isChecked();
        }
    }

}

