package com.ahmetcan7.eCommerceApp.dto;

import com.ahmetcan7.eCommerceApp.model.Product;
import com.ahmetcan7.eCommerceApp.service.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConverter {

    public ProductDto convert(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .stock(product.getStock())
                .discountRate(product.getDiscountRate())
                .category(product.getCategory())
                .brand(product.getBrand())
                .afterDiscountPrice(ProductService.calculatePriceAfterDiscount(product))
                .build();
    }

}
