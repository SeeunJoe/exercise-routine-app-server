package com.metacoding.exerciseappserver.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class CategoryController {
    private final CategoryRepository categoryRepository;
}
