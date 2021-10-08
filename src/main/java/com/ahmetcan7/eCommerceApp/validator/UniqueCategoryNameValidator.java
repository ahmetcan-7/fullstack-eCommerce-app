package com.ahmetcan7.eCommerceApp.validator;

import com.ahmetcan7.eCommerceApp.repository.CategoryRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCategoryNameValidator implements ConstraintValidator<UniqueCategoryName,String> {
    private final CategoryRepository categoryRepository;

    public UniqueCategoryNameValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isValid(String categoryName, ConstraintValidatorContext context) {
        return !categoryRepository.existsByCategoryName(categoryName);
    }
}
