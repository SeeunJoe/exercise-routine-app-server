package com.metacoding.exerciseappserver.fitness;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class FitnessRepository {
    private final EntityManager em;

    // 운동리스트 전체 다 가져오기
    public List<Fitness> findAll() {
        return em.createQuery("select f from Fitness f", Fitness.class)
                .getResultList();
    }
}