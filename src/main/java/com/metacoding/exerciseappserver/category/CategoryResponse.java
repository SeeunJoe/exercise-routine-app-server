package com.metacoding.exerciseappserver.category;

import lombok.Data;

public class CategoryResponse {

    @Data
    public static class CategoryDTO {
        private Integer categoryId;
        private String categoryName;

        public CategoryDTO(Category category) {
            this.categoryId = category.getId();
            this.categoryName = category.getName();
        }
    }
}
