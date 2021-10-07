package com.ahmetcan7.eCommerceApp.controller;

import com.ahmetcan7.eCommerceApp.dto.CategoryDto;
import com.ahmetcan7.eCommerceApp.dto.CreateCategoryRequest;
import com.ahmetcan7.eCommerceApp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getCategoryDtoById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest){
        return ResponseEntity.ok(categoryService.createCategory(createCategoryRequest));
    }
}
