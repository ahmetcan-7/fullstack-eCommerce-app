package com.ahmetcan7.eCommerceApp.controller;

import com.ahmetcan7.eCommerceApp.dto.BrandDto;
import com.ahmetcan7.eCommerceApp.dto.CreateBrandRequest;
import com.ahmetcan7.eCommerceApp.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/{id}")
    public ResponseEntity<BrandDto> getBrandById(@PathVariable Long id){
        return ResponseEntity.ok(brandService.getBrandDtoById(id));
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> getAllBrands(){
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @PostMapping
    public ResponseEntity<?> createBrand(@Valid @RequestBody CreateBrandRequest createBrandRequest){
        return ResponseEntity.ok(brandService.createBrand(createBrandRequest));
    }

}
