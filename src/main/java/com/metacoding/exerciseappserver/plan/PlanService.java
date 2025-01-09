package com.metacoding.exerciseappserver.plan;

import com.metacoding.exerciseappserver._core.util.CommonData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PlanService {
    private final PlanRepository planRepository;

    public PlanResponse.UserWeekInfoDTO findUserWeekInfo(Integer userId) {

        List<Plan> planList = planRepository.findUserWeekInfo(userId);

        List<WeekInformation> weekInformationList = new ArrayList<>();

        if (planList.isEmpty()) {
            List<String> emptyList = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                weekInformationList.add(new WeekInformation(CommonData.weekNameArr[i], emptyList));
            }
        } else {
            for (int i = 0; i < planList.size(); i++) {
                List<String> fitnessNameList = new ArrayList<>();
                for (Plan plan : planList) {
                    if (plan.getDayOfWeek().equals(CommonData.weekNameArr[i])) {
                        fitnessNameList.add("[" + plan.getFitness().getFitnessName() + "]");
                    }
                }
                weekInformationList.add(new WeekInformation(CommonData.weekNameArr[i], fitnessNameList));
            }
        }

        for (int i = 0; i < weekInformationList.size(); i++) {
            if (weekInformationList.get(i).fitnessNameList.isEmpty()) {
                weekInformationList.get(i).fitnessNameList.add("등록된 정보가 없습니다");
            }
        }

        return new PlanResponse.UserWeekInfoDTO(weekInformationList);
    }
}
