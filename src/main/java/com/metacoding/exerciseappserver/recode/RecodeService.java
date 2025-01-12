package com.metacoding.exerciseappserver.recode;

import com.metacoding.exerciseappserver._core.util.CommonData;
import com.metacoding.exerciseappserver.plan.Plan;
import com.metacoding.exerciseappserver.plan.PlanRepository;
import com.metacoding.exerciseappserver.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
@EnableScheduling // 스케줄링 기능 활성화
public class RecodeService {
    private final RecodeRepository recodeRepository;
    private final PlanRepository planRepository;
    private final UserRepository userRepository;

    public RecodeRequest.RecodeDTO findAllRecodeByUserId(Integer userId) {
        List<Recode> recodeList = recodeRepository.findAllRecodeByUserId(userId);
        List<RecodeRequest.RecodeInformation> list = new ArrayList<>();
        for (Recode recode : recodeList) {
            list.add(new RecodeRequest.RecodeInformation(recode));
        }
        return new RecodeRequest.RecodeDTO(list);
    }

    @Transactional
    @Scheduled(cron = "0 15 1 * * MON") // 매주 월요일 오전 3시 15분에 실행
    public void updateAllUserPlan() {
        // 모든 Plan을 유저 아이디 기준으로 오름차순 정렬하여 가져오기
        List<Plan> planList = planRepository.findAllPlan();
        Set<Integer> userIdSet = new HashSet<>();
        for (Plan plan : planList) {
            userIdSet.add(plan.getUser().getId());
        }
        List<Integer> userIdList = new ArrayList<>(userIdSet);

        for (int userId : userIdList) {
            int count = 0;
            LocalDateTime baseCreatedAt = LocalDateTime.now(); // 기본 날짜 설정
            while (count < 7) {
                boolean found = false;
                for (Plan plan : planList) {
                    if (plan.getUser().getId() == userId && plan.getDayOfWeek().equals(CommonData.weekNameArr[count])) {
                        boolean isChecked = plan.getFitnessCheckStatus();
                        LocalDateTime createdAt = baseCreatedAt.minusDays(7 - count); // 날짜를 유동적으로 조정
                        recodeRepository.save(Recode.builder()
                                .user(userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user ID")))
                                .createdAt(createdAt)
                                .isChecked(isChecked)
                                .build());
                        count++;
                        found = true;
                        break; // 내부 루프 탈출
                    }
                }
                if (!found) {
                    count++; // 찾지 못한 경우에도 count 증가
                }
            }
        }
        // 모든 Plan을 초기화
        for (Plan plan : planList) {
            plan.updatePlan(null, null, null, false);
        }
    }
}
