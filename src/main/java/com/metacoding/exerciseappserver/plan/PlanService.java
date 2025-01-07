package com.metacoding.exerciseappserver.plan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlanService {
    private final PlanRepository planRepository;
}
