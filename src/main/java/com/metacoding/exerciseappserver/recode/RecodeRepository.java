package com.metacoding.exerciseappserver.recode;

import com.metacoding.exerciseappserver.fitness.Fitness;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class RecodeRepository {
    final private EntityManager em;

    public List<Recode> findAllRecodeByUserId(Integer userId) {
        Query q = em.createQuery("select r from Recode r where r.user.id = :userId", Recode.class);
        q.setParameter("userId", userId);
        return q.getResultList();
    }

    @Transactional
    public void save(Recode recode) {
        em.persist(recode);
    }
}
