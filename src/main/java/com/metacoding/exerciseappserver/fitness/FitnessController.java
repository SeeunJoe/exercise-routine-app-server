package com.metacoding.exerciseappserver.fitness;

import com.metacoding.exerciseappserver._core.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FitnessController {
    private final FitnessService fitnessService;

    // 운동 전체 리스트 보내주기
    @GetMapping("/fitness-list")
    public ResponseEntity<?> fitnessList() {
        List<FitnessResponse.FitnessDTO> dto = fitnessService.getFitnessList();

        System.out.println("dlrj dltajwfefvewv");

        return ResponseEntity.ok()
                .body(ApiUtil.success(dto));
    }

    @GetMapping("/fitness/detail/{id}")
    public ResponseEntity<?> fitnessDetail(@PathVariable Long id) {
        FitnessResponse.FitnessDetailDTO fitnessDetailDTO = fitnessService.getFitnessById(id);

        return ResponseEntity.ok(ApiUtil.success(fitnessDetailDTO));
    }

    @GetMapping("/fitness/{id}")
    public ResponseEntity<?> exerciseById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(ApiUtil.success(fitnessService.findByFitnessFitnessId(id)));
    }
}

