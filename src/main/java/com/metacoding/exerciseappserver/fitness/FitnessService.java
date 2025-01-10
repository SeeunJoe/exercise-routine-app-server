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
        return fitnessRepository.findAll().stream()
                .map(FitnessResponse.FitnessDTO::new)
                .toList();
    }
    public FitnessResponse.fitnessDTO findByFitnessFitnessId(int id) {
        return new FitnessResponse.fitnessDTO(fitnessRepository.findByFitnessId(id));
    }
}
