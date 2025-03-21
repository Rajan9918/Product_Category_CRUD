package com.code.Service;

import com.code.Entity.Category;
import org.springframework.data.domain.Page;

public interface CategoryService {
     Category createCategory(Category category);
     Category getCategoryById(Long id);
     Page<Category> getAllCategories(int page);
     String updateCategory(Long id, Category categoryDetails);
     String deleteCategory(Long id);

}
