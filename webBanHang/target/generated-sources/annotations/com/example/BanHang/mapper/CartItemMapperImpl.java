package com.example.BanHang.mapper;

import com.example.BanHang.dto.request.CartItemCreationRequest;
import com.example.BanHang.dto.request.CartItemUpdateRequest;
import com.example.BanHang.dto.response.CartItemResponse;
import com.example.BanHang.entity.Cart;
import com.example.BanHang.entity.CartItem;
import com.example.BanHang.entity.Product;
import com.example.BanHang.entity.User;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-12T16:56:46+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class CartItemMapperImpl implements CartItemMapper {

    @Override
    public CartItem toCartItem(CartItemCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        CartItem.CartItemBuilder cartItem = CartItem.builder();

        cartItem.cart( cartItemCreationRequestToCart( request ) );
        cartItem.products( cartItemCreationRequestToProduct( request ) );
        cartItem.quantity( request.getQuantity() );

        return cartItem.build();
    }

    @Override
    public CartItemResponse toCartItemResponse(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        CartItemResponse.CartItemResponseBuilder cartItemResponse = CartItemResponse.builder();

        Integer id = cartItemCartId( cartItem );
        if ( id != null ) {
            cartItemResponse.cartId( id.longValue() );
        }
        cartItemResponse.productId( cartItemProductsId( cartItem ) );
        cartItemResponse.productName( cartItemProductsName( cartItem ) );
        cartItemResponse.image( cartItemProductsImage( cartItem ) );
        cartItemResponse.price( cartItemProductsPrice( cartItem ) );
        cartItemResponse.stock( cartItemProductsStock( cartItem ) );
        cartItemResponse.description( cartItemProductsDescription( cartItem ) );
        cartItemResponse.userId( cartItemCartUserId( cartItem ) );
        cartItemResponse.username( cartItemCartUserUsername( cartItem ) );
        cartItemResponse.quantity( cartItem.getQuantity() );

        return cartItemResponse.build();
    }

    @Override
    public List<CartItemResponse> toCartItemList(List<CartItem> response) {
        if ( response == null ) {
            return null;
        }

        List<CartItemResponse> list = new ArrayList<CartItemResponse>( response.size() );
        for ( CartItem cartItem : response ) {
            list.add( toCartItemResponse( cartItem ) );
        }

        return list;
    }

    @Override
    public void updateCartItem(CartItem cartItem, CartItemUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getId() != null ) {
            cartItem.setId( Integer.parseInt( request.getId() ) );
        }
        else {
            cartItem.setId( null );
        }
        cartItem.setQuantity( request.getQuantity() );
    }

    protected Cart cartItemCreationRequestToCart(CartItemCreationRequest cartItemCreationRequest) {
        if ( cartItemCreationRequest == null ) {
            return null;
        }

        Cart.CartBuilder cart = Cart.builder();

        cart.id( cartItemCreationRequest.getCartId() );

        return cart.build();
    }

    protected Product cartItemCreationRequestToProduct(CartItemCreationRequest cartItemCreationRequest) {
        if ( cartItemCreationRequest == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( cartItemCreationRequest.getProductId() );

        return product.build();
    }

    private Integer cartItemCartId(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Cart cart = cartItem.getCart();
        if ( cart == null ) {
            return null;
        }
        Integer id = cart.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer cartItemProductsId(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Product products = cartItem.getProducts();
        if ( products == null ) {
            return null;
        }
        Integer id = products.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String cartItemProductsName(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Product products = cartItem.getProducts();
        if ( products == null ) {
            return null;
        }
        String name = products.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String cartItemProductsImage(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Product products = cartItem.getProducts();
        if ( products == null ) {
            return null;
        }
        String image = products.getImage();
        if ( image == null ) {
            return null;
        }
        return image;
    }

    private BigDecimal cartItemProductsPrice(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Product products = cartItem.getProducts();
        if ( products == null ) {
            return null;
        }
        BigDecimal price = products.getPrice();
        if ( price == null ) {
            return null;
        }
        return price;
    }

    private Integer cartItemProductsStock(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Product products = cartItem.getProducts();
        if ( products == null ) {
            return null;
        }
        Integer stock = products.getStock();
        if ( stock == null ) {
            return null;
        }
        return stock;
    }

    private String cartItemProductsDescription(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Product products = cartItem.getProducts();
        if ( products == null ) {
            return null;
        }
        String description = products.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private String cartItemCartUserId(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Cart cart = cartItem.getCart();
        if ( cart == null ) {
            return null;
        }
        User user = cart.getUser();
        if ( user == null ) {
            return null;
        }
        String id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String cartItemCartUserUsername(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Cart cart = cartItem.getCart();
        if ( cart == null ) {
            return null;
        }
        User user = cart.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }
}
