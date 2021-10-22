package com.ahmetcan7.eCommerceApp.repository;

import com.ahmetcan7.eCommerceApp.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository  extends PagingAndSortingRepository<Product, Long> {

}
