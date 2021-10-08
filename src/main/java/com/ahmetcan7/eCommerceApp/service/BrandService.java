package com.ahmetcan7.eCommerceApp.service;

import com.ahmetcan7.eCommerceApp.dto.BrandDto;
import com.ahmetcan7.eCommerceApp.dto.BrandDtoConverter;
import com.ahmetcan7.eCommerceApp.dto.CreateBrandRequest;
import com.ahmetcan7.eCommerceApp.exception.NotFoundException;
import com.ahmetcan7.eCommerceApp.model.Brand;
import com.ahmetcan7.eCommerceApp.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    private final BrandDtoConverter brandDtoConverter;

    public BrandDto getBrandDtoById(Long id){
        final Brand brand= brandRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Brand not found with id:"+id));

        return brandDtoConverter.convert(brand);

    }

    public List<BrandDto> getAllBrands(){
        final List<Brand> brandList = brandRepository.findAll();

        return brandList.stream().map(brandDtoConverter::convert).collect(Collectors.toList());
    }

    public BrandDto createBrand(CreateBrandRequest createBrandRequest){
        final Brand brand = new Brand();
        brand.setBrandName(createBrandRequest.getBrandName());

        return brandDtoConverter.convert(brandRepository.save(brand));
    }

    protected Brand getBrandById(long id){
        return brandRepository.findById(id).orElseThrow(()->new NotFoundException("Brand not found with id: "+id));
    }
}
