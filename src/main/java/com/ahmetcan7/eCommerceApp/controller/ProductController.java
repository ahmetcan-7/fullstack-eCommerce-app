package com.ahmetcan7.eCommerceApp.controller;

import com.ahmetcan7.eCommerceApp.dto.CreateProductRequest;
import com.ahmetcan7.eCommerceApp.dto.ProductDto;
import com.ahmetcan7.eCommerceApp.dto.UpdateProductRequest;
import com.ahmetcan7.eCommerceApp.model.Product;
import com.ahmetcan7.eCommerceApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/getAllByPage")
    public ResponseEntity<Page<ProductDto>> getAllProducts(@RequestParam Integer pageNo, @RequestParam Integer pageSize,
                                                           @RequestParam String sortBy){

    Page<ProductDto> productList = productService.getAllProducts(pageNo-1,pageSize,sortBy);
    return ResponseEntity.ok(productList);
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
