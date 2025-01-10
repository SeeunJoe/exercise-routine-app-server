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

    public List<FitnessResponse.FitnessDTO> getFitnessList() {
        System.out.println("tlqfkd");

        return fitnessRepository.findAll().stream()
                .map(FitnessResponse.FitnessDTO::new)
                .toList();
    }
    public FitnessResponse.AddFitnessDTO findByFitnessFitnessId(int id) {
        return new FitnessResponse.AddFitnessDTO(fitnessRepository.findByFitnessId(id));
    }
}
