package com.metacoding.exerciseappserver.fitness;

import com.metacoding.exerciseappserver._core.error.exception.Exception500;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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

    public List<Fitness> findById(int categoryId) {
        Query q =  em.createQuery("select f from Fitness f join fetch f.category c where c.id =:categoryId", Fitness.class);
        q.setParameter("categoryId",categoryId);
        try {
            return q.getResultList();
        } catch (Exception e) {
            throw new Exception500("카테고리에 운동 없음");
        }
    }

    public Fitness findByFitnessId(Integer fitnessId) {
        Query q = em.createQuery("select f from Fitness f where f.id =:fitnessId", Fitness.class);
        q.setParameter("fitnessId",fitnessId);
        return (Fitness) q.getSingleResult();
    }
}