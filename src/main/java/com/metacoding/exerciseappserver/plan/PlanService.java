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
        for (int i = 0; i < planList.size(); i++) {
            List<String> fitnessNameList = new ArrayList<>();
            for (Plan plan : planList) {
                if (plan.getDayOfWeek().equals(CommonData.weekNameArr[i])) {
                    fitnessNameList.add(plan.getFitness().getFitnessName());
                }
            }
            weekInformationList.add(new WeekInformation(CommonData.weekNameArr[i], fitnessNameList));
        }

        return new PlanResponse.UserWeekInfoDTO(weekInformationList);
    }
}
