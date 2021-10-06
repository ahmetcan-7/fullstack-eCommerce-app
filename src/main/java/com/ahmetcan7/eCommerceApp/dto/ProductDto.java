package com.ahmetcan7.eCommerceApp.dto;

import com.ahmetcan7.eCommerceApp.model.Brand;
import com.ahmetcan7.eCommerceApp.model.Category;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private long id;
    private String productName;
    private double price;
    private int stock;
    private double discountRate;
    private Category category;
    private Brand brand;
    private double afterDiscountPrice;



}
