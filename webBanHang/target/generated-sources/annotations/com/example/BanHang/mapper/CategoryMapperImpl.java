package com.example.BanHang.mapper;

import com.example.BanHang.dto.request.CategoryCreationRequest;
import com.example.BanHang.dto.request.CategoryUpdateRequest;
import com.example.BanHang.dto.response.CategoryResponse;
import com.example.BanHang.entity.Categories;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-12T16:56:46+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Categories toCategory(CategoryCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        Categories.CategoriesBuilder categories = Categories.builder();

        categories.description( request.getDescription() );
        categories.name( request.getName() );

        return categories.build();
    }

    @Override
    public CategoryResponse toCategoryResponse(Categories categories) {
        if ( categories == null ) {
            return null;
        }

        CategoryResponse.CategoryResponseBuilder categoryResponse = CategoryResponse.builder();

        categoryResponse.description( categories.getDescription() );
        categoryResponse.name( categories.getName() );

        return categoryResponse.build();
    }

    @Override
    public void toUpdateCategory(Categories categories, CategoryUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        categories.setDescription( request.getDescription() );
        categories.setName( request.getName() );
    }
}
