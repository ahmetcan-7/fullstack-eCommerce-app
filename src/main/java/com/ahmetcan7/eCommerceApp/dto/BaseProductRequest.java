package com.ahmetcan7.eCommerceApp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseProductRequest {

    @NotNull(message = "ProductName must not be null")
    @Size(min = 3,max = 50,message = "product name size must be between {min} and {max}")
    private String productName;

    @NotNull(message = "Price must not be null")
    @Min(0)
    private double price;

    @Min(0)
    private int stock;

    @Min(0)
    private double discountRate;

    private Long categoryId;

    private Long brandId;

}
