package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.CartItem;
import com.ecommerce.service.CartItemService;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

	@Autowired
	private CartItemService cartItemService;

	@GetMapping
	public List<CartItem> getAllCartItems() {
		return cartItemService.getAllCartItems();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CartItem> getCartItemById(@PathVariable Long id) {
		return cartItemService.getCartItemById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public CartItem addCartItem(@RequestBody CartItem cartItem) {
		return cartItemService.addCartItem(cartItem);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CartItem> updateCartItem(@PathVariable Long id, @RequestBody CartItem cartItemDetails) {
		try {
			CartItem updatedCartItem = cartItemService.updateCartItem(id, cartItemDetails);
			return ResponseEntity.ok(updatedCartItem);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
		cartItemService.deleteCartItem(id);
		return ResponseEntity.noContent().build();
	}
}
