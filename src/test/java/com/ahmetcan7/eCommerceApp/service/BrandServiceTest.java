package com.ahmetcan7.eCommerceApp.service;

import com.ahmetcan7.eCommerceApp.dto.BrandDto;
import com.ahmetcan7.eCommerceApp.dto.BrandDtoConverter;
import com.ahmetcan7.eCommerceApp.dto.CreateBrandRequest;
import com.ahmetcan7.eCommerceApp.exception.NotFoundException;
import com.ahmetcan7.eCommerceApp.model.Brand;
import com.ahmetcan7.eCommerceApp.repository.BrandRepository;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class BrandServiceTest {

    private BrandService brandService;

    @Mock
    private BrandRepository brandRepository;
    @Mock
    private BrandDtoConverter brandDtoConverter;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        brandService=new BrandService(brandRepository,brandDtoConverter);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testGetBrandDtoById_whenBrandDtoIdExists_shouldReturnBrand() {
        //given
        Brand brand= new Brand(1L,"brand-name", Set.of());
        BrandDto brandDto =new BrandDto(1L,"brand-name");
        //when
        Mockito.when(brandRepository.findById(1L)).thenReturn(Optional.of(brand));
        Mockito.when(brandDtoConverter.convert(brand)).thenReturn(brandDto);
        BrandDto result= brandService.getBrandDtoById(1L);
        //then
        assertEquals(result,brandDto);
        Mockito.verify(brandRepository).findById(1L);
        Mockito.verify(brandDtoConverter).convert(brand);
    }

    @Test
    void testGetBrandDtoById_whenBrandDtoIdDoesNotExists_shouldThrowNotFoundException() {
        //when
        Mockito.when(brandRepository.findById(1L)).thenReturn(Optional.empty());
        //then
        assertThrows(NotFoundException.class,()->brandService.getBrandById(1L));
        Mockito.verify(brandRepository).findById(1L);
        Mockito.verifyNoInteractions(brandDtoConverter);
    }

    @Test
    void testCreateBrand_whenCalledWithValidRequest_shouldReturnValidBrandDto() {
        //given
        CreateBrandRequest createBrandRequest =new CreateBrandRequest("brand-name");

        Brand brand = new Brand();
        brand.setBrandName(createBrandRequest.getBrandName());

        BrandDto brandDto = new BrandDto(1L,"brand-name");
        //when
        Mockito.when(brandRepository.save(brand)).thenReturn(brand);
        Mockito.when(brandDtoConverter.convert(brand)).thenReturn(brandDto);

        BrandDto result= brandService.createBrand(createBrandRequest);
        //then
        assertEquals(result,brandDto);

        Mockito.verify(brandRepository).save(brand);
        Mockito.verify(brandDtoConverter).convert(brand);

    }
}
