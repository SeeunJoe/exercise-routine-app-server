package com.metacoding.exerciseappserver.fitness;

import com.metacoding.exerciseappserver._core.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class FitnessController {
    private final FitnessService fitnessService;

    // 운동리스트 전체 가져오기
    @GetMapping("/exercise-list")
    public @ResponseBody ResponseEntity<?> exerciseList() {
        List<FitnessResponse.ExerciseListDTO> dto = fitnessService.getFitnessList();
        return ResponseEntity.ok()
                .body(ApiUtil.success(dto));
    }
}

