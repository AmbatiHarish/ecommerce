package com.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.CartItem;
import com.ecommerce.repository.CartItemRepository;
import com.ecommerce.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public List<CartItem> getAllCartItems() {
		return cartItemRepository.findAll();
	}

	@Override
	public Optional<CartItem> getCartItemById(Long id) {
		return cartItemRepository.findById(id);
	}

	@Override
	public CartItem addCartItem(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

	@Override
	public CartItem updateCartItem(Long id, CartItem cartItemDetails) {
		return cartItemRepository.findById(id).map(cartItem -> {
			cartItem.setProduct(cartItemDetails.getProduct());
			cartItem.setQuantity(cartItemDetails.getQuantity());
			return cartItemRepository.save(cartItem);
		}).orElseThrow(() -> new RuntimeException("CartItem not found"));
	}

	@Override
	public void deleteCartItem(Long id) {
		cartItemRepository.deleteById(id);
	}
}
