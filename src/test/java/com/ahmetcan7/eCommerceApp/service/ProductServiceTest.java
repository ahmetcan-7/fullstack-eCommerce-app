package com.ahmetcan7.eCommerceApp.service;

import com.ahmetcan7.eCommerceApp.dto.CreateProductRequest;
import com.ahmetcan7.eCommerceApp.dto.ProductDto;
import com.ahmetcan7.eCommerceApp.dto.ProductDtoConverter;
import com.ahmetcan7.eCommerceApp.exception.NotFoundException;
import com.ahmetcan7.eCommerceApp.model.Brand;
import com.ahmetcan7.eCommerceApp.model.Category;
import com.ahmetcan7.eCommerceApp.model.Product;
import com.ahmetcan7.eCommerceApp.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private AutoCloseable autoCloseable;

    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductDtoConverter productDtoConverter;

    @Mock
    private CategoryService categoryService;

    @Mock
    private BrandService brandService;


    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        productService = new ProductService(productRepository,productDtoConverter,categoryService,brandService);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testGetProductById_whenProductIdExists_shouldReturnProductDto() {
        //given
        Product product = generateProduct();
        ProductDto productDto = generateProductDto();
        //when
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Mockito.when(productDtoConverter.convert(product)).thenReturn(productDto);
        ProductDto result=productService.getProductById(1L);
        //then
        assertEquals(result,productDto);
        Mockito.verify(productRepository).findById(1L);
        Mockito.verify(productDtoConverter).convert(product);
    }

    @Test
    void testGetProductById_whenProductIdDoesNotExists_shouldReturnProductDto() {
        //when
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.empty());
        //then
        assertThrows(NotFoundException.class,() -> productService.getProductById(1L));
        Mockito.verify(productRepository).findById(1L);
        Mockito.verifyNoInteractions(productDtoConverter);
    }

    @Test
    void testCreateProduct_whenCalledWithValidRequest_shouldReturnValidProductDto() {
        //given
        Category category = generateCategory();
        Brand brand = generateBrand();
        ProductDto productDto = generateProductDto();
        CreateProductRequest createProductRequest = generateCreateProductRequest();

        Product product =Product.builder()
                .productName(createProductRequest.getProductName())
                .price(createProductRequest.getPrice())
                .stock(createProductRequest.getStock())
                .discountRate(createProductRequest.getDiscountRate())
                .category(category)
                .brand(brand)
                .build();
        //when
        Mockito.when(categoryService.getCategoryById(createProductRequest.getCategoryId())).thenReturn(category);
        Mockito.when(brandService.getBrandById(createProductRequest.getBrandId())).thenReturn(brand);
        Mockito.when(productDtoConverter.convert(product)).thenReturn(productDto);
        Mockito.when(productRepository.save(product)).thenReturn(product);

        ProductDto result=productService.createProduct(createProductRequest);

        //then
        assertEquals(result,productDto);
        Mockito.verify(categoryService).getCategoryById(createProductRequest.getCategoryId());
        Mockito.verify(brandService).getBrandById(createProductRequest.getBrandId());
        Mockito.verify(productDtoConverter).convert(product);
        Mockito.verify(productRepository).save(product);

    }

    @Test
    void calculatePriceAfterDiscount() {
        //given
        Product product = generateProduct();

        //when
        double result = ProductService.calculatePriceAfterDiscount(product);

        //then
        assertEquals(result,8);
    }

    private Category generateCategory(){
        return new Category(2L,"category-name", Set.of());
    }

    private Brand generateBrand(){
        return new Brand(3L,"brand-name",Set.of());
    }

    private Product generateProduct(){
        Brand brand =generateBrand();
        Category category =generateCategory();
        return Product.builder()
                .id(1L)
                .price(10)
                .stock(20)
                .discountRate(20)
                .productName("product-name")
                .brand(brand)
                .category(category)
                .build();
    }

    private ProductDto generateProductDto(){
        Brand brand =generateBrand();
        Category category =generateCategory();
        return ProductDto.builder()
                .id(1L)
                .afterDiscountPrice(8)
                .brand(brand)
                .category(category)
                .discountRate(20)
                .stock(20)
                .price(10)
                .productName("product-name")
                .build();
    }

    private CreateProductRequest generateCreateProductRequest(){
        Brand brand =generateBrand();
        Category category =generateCategory();

        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setProductName("product-name");
        createProductRequest.setPrice(10);
        createProductRequest.setStock(20);
        createProductRequest.setDiscountRate(20);
        createProductRequest.setBrandId(brand.getId());
        createProductRequest.setCategoryId(category.getId());

        return createProductRequest;
    }
}