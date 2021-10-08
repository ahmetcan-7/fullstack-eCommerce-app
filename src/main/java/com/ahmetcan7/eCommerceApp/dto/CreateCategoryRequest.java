package com.ahmetcan7.eCommerceApp.dto;

import com.ahmetcan7.eCommerceApp.validator.UniqueCategoryName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {

    @NotBlank
    @UniqueCategoryName
    private String categoryName;
}
