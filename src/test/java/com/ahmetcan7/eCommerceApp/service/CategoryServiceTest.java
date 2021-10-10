package com.ahmetcan7.eCommerceApp.service;

import com.ahmetcan7.eCommerceApp.dto.CategoryDto;
import com.ahmetcan7.eCommerceApp.dto.CategoryDtoConverter;
import com.ahmetcan7.eCommerceApp.dto.CreateCategoryRequest;
import com.ahmetcan7.eCommerceApp.exception.NotFoundException;
import com.ahmetcan7.eCommerceApp.model.Category;
import com.ahmetcan7.eCommerceApp.repository.CategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CategoryDtoConverter categoryDtoConverter;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        categoryService=new CategoryService(categoryRepository,categoryDtoConverter);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testGetCategoryDtoById_whenCategoryDtoIdExists_shouldReturnCategory() {
        //given
        Category category= new Category(1L,"category-name",Set.of());
        CategoryDto categoryDto =new CategoryDto(1L,"category-name");
        //when
        Mockito.when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        Mockito.when(categoryDtoConverter.convert(category)).thenReturn(categoryDto);
        CategoryDto result= categoryService.getCategoryDtoById(1L);
        //then
        assertEquals(result,categoryDto);
        Mockito.verify(categoryRepository).findById(1L);
        Mockito.verify(categoryDtoConverter).convert(category);
    }

    @Test
    void testGetCategoryDtoById_whenCategoryDtoIdDoesNotExists_shouldThrowNotFoundException() {
        //when
        Mockito.when(categoryRepository.findById(1L)).thenReturn(Optional.empty());
        //then
        assertThrows(NotFoundException.class,()->categoryService.getCategoryById(1L));
        Mockito.verify(categoryRepository).findById(1L);
        Mockito.verifyNoInteractions(categoryDtoConverter);
    }

    @Test
    void testCreateCategory_whenCalledWithValidRequest_shouldReturnValidCategoryDto() {
        //given
        CreateCategoryRequest createCategoryRequest =new CreateCategoryRequest("category-name");

        Category category = new Category();
        category.setCategoryName(createCategoryRequest.getCategoryName());

        CategoryDto categoryDto = new CategoryDto(1L,"category-name");
        //when
        Mockito.when(categoryRepository.save(category)).thenReturn(category);
        Mockito.when(categoryDtoConverter.convert(category)).thenReturn(categoryDto);

        CategoryDto result= categoryService.createCategory(createCategoryRequest);
        //then
        assertEquals(result,categoryDto);

        Mockito.verify(categoryRepository).save(category);
        Mockito.verify(categoryDtoConverter).convert(category);

    }
}