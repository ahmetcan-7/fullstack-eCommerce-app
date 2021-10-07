package com.ahmetcan7.eCommerceApp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseProductRequest {

    @NotNull(message = "ProductName must not be null")
    @Size(min = 2,max = 50,message = "product name size must be between {min} and {max}")
    private String productName;

    @NotNull(message = "Price must not be null")
    @Positive
    private double price;

    @Min(0)
    @NotNull
    private int stock;

    @Min(0)
    @NotNull
    private double discountRate;

    @NotNull
    private Long categoryId;

    @NotNull
    private Long brandId;

}
