package com.metacoding.exerciseappserver.plan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PlanRepositoryTest {

    @Autowired
    private PlanRepository planRepository;

    @Test
    void contextLoads() {

        List<Plan> userWeekInfo = planRepository.findUserWeekInfo(1);
        System.out.println("--------------------");
        System.out.println("--------------------");
        System.out.println("반환 리스트 : " + userWeekInfo.toString());
        System.out.println("--------------------");
        System.out.println("--------------------");
    }
}
