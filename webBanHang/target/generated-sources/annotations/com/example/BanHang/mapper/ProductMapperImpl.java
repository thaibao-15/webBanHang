package com.example.BanHang.mapper;

import com.example.BanHang.dto.request.ProductCreationRequest;
import com.example.BanHang.dto.request.ProductUpdateRequest;
import com.example.BanHang.dto.response.ProductResponse;
import com.example.BanHang.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-12T16:56:46+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.description( request.getDescription() );
        product.image( request.getImage() );
        product.name( request.getName() );
        product.price( request.getPrice() );
        product.status( request.getStatus() );
        product.stock( request.getStock() );

        return product.build();
    }

    @Override
    public ProductResponse toProductResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse.ProductResponseBuilder productResponse = ProductResponse.builder();

        productResponse.createdAt( product.getCreatedAt() );
        productResponse.description( product.getDescription() );
        productResponse.image( product.getImage() );
        productResponse.name( product.getName() );
        productResponse.price( product.getPrice() );
        productResponse.status( product.getStatus() );
        productResponse.stock( product.getStock() );
        productResponse.updatedAt( product.getUpdatedAt() );

        return productResponse.build();
    }

    @Override
    public void toUpdateProduct(Product product, ProductUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        product.setDescription( request.getDescription() );
        product.setImage( request.getImage() );
        product.setName( request.getName() );
        product.setPrice( request.getPrice() );
        product.setStatus( request.getStatus() );
        product.setStock( request.getStock() );
        product.setUpdatedAt( request.getUpdatedAt() );
    }
}
