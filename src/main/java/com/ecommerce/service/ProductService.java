package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.model.Product;

public interface ProductService {
	List<Product> getAllProducts();

	Optional<Product> getProductById(Long id);

	Product addProduct(Product product);

	Product updateProduct(Long id, Product productDetails);

	void deleteProduct(Long id);
}
