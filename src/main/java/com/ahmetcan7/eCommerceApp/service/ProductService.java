package com.ahmetcan7.eCommerceApp.service;

import com.ahmetcan7.eCommerceApp.dto.*;
import com.ahmetcan7.eCommerceApp.exception.NotFoundException;
import com.ahmetcan7.eCommerceApp.model.Brand;
import com.ahmetcan7.eCommerceApp.model.Category;
import com.ahmetcan7.eCommerceApp.model.Product;
import com.ahmetcan7.eCommerceApp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoConverter productDtoConverter;
    private final CategoryService categoryService;
    private final BrandService brandService;

    public List<ProductDto> getAllProductsDto(){
        List<Product> productList =productRepository.findAll();

        return productList.stream().map(productDtoConverter::convert).collect(Collectors.toList());
    }

    public ProductDto getProductById(long id){
        final Product product = productRepository.findById(id)
                .orElseThrow(()->new NotFoundException("product not found"+id));

        return productDtoConverter.convert(product);
    }

    public ProductDto createProduct(CreateProductRequest createProductRequest){
        final Category category = categoryService.getCategoryById(createProductRequest.getCategoryId());
        final Brand brand = brandService.getBrandById(createProductRequest.getBrandId());

        final Product product =Product.builder()
                .productName(createProductRequest.getProductName())
                .price(createProductRequest.getPrice())
                .stock(createProductRequest.getStock())
                .discountRate(createProductRequest.getDiscountRate())
                .category(category)
                .brand(brand)
                .build();



        return productDtoConverter.convert(productRepository.save(product));

    }

    public ProductDto updateProduct(Long id, UpdateProductRequest updateProductRequest){
        final Category category = categoryService.getCategoryById(updateProductRequest.getCategoryId());
        final Brand brand = brandService.getBrandById(updateProductRequest.getBrandId());

        Optional<Product> productOptional = productRepository.findById(id);

        productOptional.ifPresent(product -> {
            product.setProductName(updateProductRequest.getProductName());
            product.setBrand(brand);
            product.setCategory(category);
            product.setPrice(updateProductRequest.getPrice());
            product.setDiscountRate(updateProductRequest.getDiscountRate());
            product.setStock(updateProductRequest.getStock());
            productRepository.save(product);
        });

        return productOptional.map(productDtoConverter::convert)
                .orElseThrow(()->new NotFoundException("product not found"));
    }

    public void deleteProduct(Long id){
        final Product product=productRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Not found Product with id: "+id));

        productRepository.deleteById(product.getId());
    }

    public static double calculatePriceAfterDiscount(Product product){
        final double discountAmount=(product.getPrice()*product.getDiscountRate())/100;
        return product.getPrice() - discountAmount;
    }

}
