package com.metacoding.exerciseappserver.fitness;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FitnessService {
    private final FitnessRepository fitnessRepository;
}
