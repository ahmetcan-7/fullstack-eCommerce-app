package com.ahmetcan7.eCommerceApp.controller;

import com.ahmetcan7.eCommerceApp.dto.CreateProductRequest;
import com.ahmetcan7.eCommerceApp.dto.ProductDto;
import com.ahmetcan7.eCommerceApp.dto.UpdateProductRequest;
import com.ahmetcan7.eCommerceApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProductsDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody CreateProductRequest createProductRequest){
        return ResponseEntity.ok(productService.createProduct(createProductRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id,
                                                    @Valid @RequestBody UpdateProductRequest updateProductRequest){

        return ResponseEntity.ok(productService.updateProduct(id,updateProductRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
