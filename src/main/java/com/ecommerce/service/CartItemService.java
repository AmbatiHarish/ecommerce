package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.model.CartItem;

public interface CartItemService {
	List<CartItem> getAllCartItems();

	Optional<CartItem> getCartItemById(Long id);

	CartItem addCartItem(CartItem cartItem);

	CartItem updateCartItem(Long id, CartItem cartItemDetails);

	void deleteCartItem(Long id);
}
