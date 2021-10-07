package com.ahmetcan7.eCommerceApp.service;

import com.ahmetcan7.eCommerceApp.dto.CategoryDto;
import com.ahmetcan7.eCommerceApp.dto.CategoryDtoConverter;
import com.ahmetcan7.eCommerceApp.dto.CreateCategoryRequest;
import com.ahmetcan7.eCommerceApp.exception.NotFoundException;
import com.ahmetcan7.eCommerceApp.model.Category;
import com.ahmetcan7.eCommerceApp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;

    public CategoryDto getCategoryDtoById(Long id){
        final Category category= categoryRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Category not found with id: "+id));

        return categoryDtoConverter.convert(category);
    }

    public List<CategoryDto> getAllCategory(){
        final List<Category> categoryList = categoryRepository.findAll();

        return categoryList.stream().map(categoryDtoConverter::convert).collect(Collectors.toList());
    }

    public CategoryDto createCategory(CreateCategoryRequest createCategoryRequest){
        final Category category = new Category();
        category.setCategoryName(createCategoryRequest.getCategoryName());

        return categoryDtoConverter.convert(categoryRepository.save(category));

    }

    protected Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElseThrow(()->new NotFoundException("Category not found"+id));
    }


}
