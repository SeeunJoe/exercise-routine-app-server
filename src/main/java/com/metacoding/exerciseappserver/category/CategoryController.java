package com.metacoding.exerciseappserver.category;

import com.metacoding.exerciseappserver._core.util.ApiUtil;
import com.metacoding.exerciseappserver.fitness.FitnessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/category-list")
    public ResponseEntity<?> findAllCategories() {
        List<CategoryResponse.CategoryDTO> dto = categoryService.getCategoryList();
        return ResponseEntity.ok()
                .body(ApiUtil.success(dto));
    }
}
