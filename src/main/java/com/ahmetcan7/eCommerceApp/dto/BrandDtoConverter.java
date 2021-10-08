package com.ahmetcan7.eCommerceApp.dto;

import com.ahmetcan7.eCommerceApp.model.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandDtoConverter {

    public BrandDto convert(Brand brand){
        return new BrandDto(brand.getId(),brand.getBrandName());
    }
}
