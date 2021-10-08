package com.ahmetcan7.eCommerceApp.dto;

import com.ahmetcan7.eCommerceApp.validator.UniqueBrandName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBrandRequest {

    @NotBlank
    @UniqueBrandName
    private String brandName;
}
