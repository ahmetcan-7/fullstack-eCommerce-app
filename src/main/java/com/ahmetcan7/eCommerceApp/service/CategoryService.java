package com.ahmetcan7.eCommerceApp.service;

import com.ahmetcan7.eCommerceApp.exception.NotFoundException;
import com.ahmetcan7.eCommerceApp.model.Category;
import com.ahmetcan7.eCommerceApp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElseThrow(()->new NotFoundException("Category not found with id: "+id));
    }


}
