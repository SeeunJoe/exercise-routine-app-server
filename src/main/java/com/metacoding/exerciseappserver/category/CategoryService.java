package com.metacoding.exerciseappserver.category;

import com.metacoding.exerciseappserver.fitness.FitnessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryResponse.CategoryDTO> getCategoryList() {

        List<Category> categoryList = categoryRepository.getCategoryList();

        return categoryList.stream()
                .map(CategoryResponse.CategoryDTO::new)
                .toList();
    }
}
