package com.code.Service;

import com.code.Entity.Category;
import com.code.Exceptions.ResourceNotFoundException;
import com.code.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category Id = "+id+" is  not found!!!!"));
    }

    public Page<Category> getAllCategories(int page) {
        return categoryRepository.findAll(PageRequest.of(page, 5));
    }

    public String updateCategory(Long id, Category categoryDetails) {
        if(categoryRepository.existsById(id)){
            Category category = getCategoryById(id);
            category.setName(categoryDetails.getName());
            categoryRepository.save(category);
            return "Update Category Id = "+id+" Successfully......";

        }
        return "Update UnSuccessfully!!!!!\n Id = "+id+" Not Persent in Database!!!!!!";
    }

    public String deleteCategory(Long id) {
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return "Category Id = "+id+" Deleted Successfully....";
        }
        else{
            return "Category Id = "+id+" Delete Unsuccessfully!!!!!";
        }
    }
}
