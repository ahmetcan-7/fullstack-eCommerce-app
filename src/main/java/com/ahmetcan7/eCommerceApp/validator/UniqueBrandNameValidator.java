package com.ahmetcan7.eCommerceApp.validator;

import com.ahmetcan7.eCommerceApp.repository.BrandRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueBrandNameValidator implements ConstraintValidator<UniqueBrandName,String> {
    private final BrandRepository brandRepository;

    public UniqueBrandNameValidator(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public boolean isValid(String BrandName, ConstraintValidatorContext context) {
        return !brandRepository.existsByBrandName(BrandName);
    }
}
