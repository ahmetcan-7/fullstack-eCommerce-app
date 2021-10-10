package com.ahmetcan7.eCommerceApp.repository;

import com.ahmetcan7.eCommerceApp.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void itShouldCheckWhenCategoryNameExists() {
        //given
        Category category = new Category();
        category.setCategoryName("category-name");

        categoryRepository.save(category);

        //when
        boolean expected = categoryRepository.existsByCategoryName(category.getCategoryName());

        //then
        assertThat(expected).isTrue();

    }

    @Test
    void itShouldCheckWhenCategoryNameDoesNotExists() {
        //given
        String categoryName="category-name";

        //when
        boolean expected = categoryRepository.existsByCategoryName(categoryName);

        //then
        assertThat(expected).isFalse();

    }
}
