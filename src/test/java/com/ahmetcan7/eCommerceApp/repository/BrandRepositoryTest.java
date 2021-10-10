package com.ahmetcan7.eCommerceApp.repository;

import com.ahmetcan7.eCommerceApp.model.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    @Test
    void itShouldCheckWhenBrandNameExists() {
        //given
        Brand brand = new Brand();
        brand.setBrandName("brand-name");

        brandRepository.save(brand);

        //when
        boolean expected = brandRepository.existsByBrandName(brand.getBrandName());

        //then
        assertThat(expected).isTrue();

    }

    @Test
    void itShouldCheckWhenBrandNameDoesNotExists() {
        //given
        String brandName="brand-name";

        //when
        boolean expected = brandRepository.existsByBrandName(brandName);

        //then
        assertThat(expected).isFalse();

    }
}