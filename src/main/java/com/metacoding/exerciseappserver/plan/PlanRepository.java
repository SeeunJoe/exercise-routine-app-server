package com.metacoding.exerciseappserver.plan;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PlanRepository {
    private final EntityManager em;
}
