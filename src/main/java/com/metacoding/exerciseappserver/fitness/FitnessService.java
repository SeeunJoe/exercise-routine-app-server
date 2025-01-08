package com.metacoding.exerciseappserver.fitness;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FitnessService {
    private final FitnessRepository fitnessRepository;


    public List<FitnessResponse.ExerciseListDTO> getFitnessList() {
        List<FitnessResponse.ExerciseListDTO> list = fitnessRepository.findAll().stream()
                .map(FitnessResponse.ExerciseListDTO::new)
                .toList();

        return list;
    }
}
