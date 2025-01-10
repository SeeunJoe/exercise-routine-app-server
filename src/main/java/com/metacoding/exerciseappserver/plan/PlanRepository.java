package com.metacoding.exerciseappserver.plan;

import jakarta.persistence.EntityManager;
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


    public Plan findByPlanId(Integer id) {
        String jpql = "select p from Plan p where p.id = :planId";
        Query q = em.createQuery(jpql, Plan.class);
        q.setParameter("planId", id);
        Plan planData = (Plan) q.getSingleResult();
        return  planData;
    }

    public void updatePlanData(Plan plan) {
        String jpql = "update Plan p set p.exerciseSet = :exerciseSet, p.repeat = :repeat, p.weight = :weight where p.id = :planId";
        Query q = em.createQuery(jpql);
        q.setParameter("exerciseSet", plan.getExerciseSet());
        q.setParameter("repeat", plan.getRepeat());
        q.setParameter("weight", plan.getWeight());
        q.setParameter("planId", plan.getId());

        q.executeUpdate();
    }

    // 요일 별 운동 리스트 조회
    public List<Plan> findPlanOfDay(Integer userId, String day) {
        String jpql = "select p from Plan p join fetch p.fitness f where p.user.id = :userId and p.dayOfWeek = :day";
        Query q = em.createQuery(jpql, Plan.class);
        q.setParameter("userId", userId);
        q.setParameter("day", day);

        return q.getResultList();
    }

    // 요일 별 운동 리스트 중 운동 삭제
    public void deletePlanData(Integer planId) {
        String jpql = "delete from Plan p where p.id = :planId";
        Query q = em.createQuery(jpql);
        q.setParameter("planId", planId);
        q.executeUpdate();
    }
}
