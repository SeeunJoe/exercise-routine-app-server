package com.metacoding.exerciseappserver.fitness;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class FitnessRepository {
    private final EntityManager em;
}
