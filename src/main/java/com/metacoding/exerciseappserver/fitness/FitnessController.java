package com.metacoding.exerciseappserver.fitness;

import com.metacoding.exerciseappserver._core.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FitnessController {
    private final FitnessService fitnessService;

    // 운동 전체 리스트 보내주기
    @GetMapping("/fitness-list")
    public ResponseEntity<?> exerciseList() {
        List<FitnessResponse.ExerciseListDTO> dto = fitnessService.getFitnessList();
        return ResponseEntity.ok()
                .body(ApiUtil.success(dto));
    }

    // 카테고리에 따른 운동 리스트 보내주기/
    @GetMapping("/fitness-list/{categoryId}")
    public ResponseEntity<?> exerciseListByCate(@PathVariable("categoryId") int categoryId) {
        List<FitnessResponse.ListByCateDTO> dto = fitnessService.getFitnessListByCate(categoryId);
        return ResponseEntity.ok()
                .body(ApiUtil.success(dto));
    }
    @GetMapping("/fitness/{id}")
    public ResponseEntity<?> exerciseById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(ApiUtil.success(fitnessService.findByFitnessFitnessId(id)));
    }
}

