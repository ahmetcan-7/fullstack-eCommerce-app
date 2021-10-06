package com.ahmetcan7.eCommerceApp.service;

import com.ahmetcan7.eCommerceApp.exception.NotFoundException;
import com.ahmetcan7.eCommerceApp.model.Brand;
import com.ahmetcan7.eCommerceApp.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    public Brand getBrandById(long id){
        return brandRepository.findById(id).orElseThrow(()->new NotFoundException("Brand not found with id: "+id));
    }
}
