package com.metacoding.exerciseappserver.plan;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class PlanRepository {
    private final EntityManager em;

    public List<Plan> findUserWeekInfo(Integer userId) {
        String jpql = "select p from Plan p join fetch p.fitness f where p.user.id = :userId";
        Query q = em.createQuery(jpql, Plan.class);
        q.setParameter("userId", userId);

        return q.getResultList();
    }


}
