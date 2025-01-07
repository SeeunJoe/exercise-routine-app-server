package com.metacoding.exerciseappserver.plan;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class PlanController {
    private final PlanService planService;
}
