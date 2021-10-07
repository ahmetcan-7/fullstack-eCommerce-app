package com.ahmetcan7.eCommerceApp.dto;

import com.ahmetcan7.eCommerceApp.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {

   public CategoryDto convert(Category category){
       return new CategoryDto(category.getId(),category.getCategoryName());
   }
}
