package com.will.twsystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.will.twsystem.domain.Product;
import com.will.twsystem.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product find(int id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.orElseThrow(()-> new com.will.twsystem.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! ID:  " + id + ", "+ Product.class.getName()));
	}
	
	public Product insert(Product product) {
		product.setId(null);
		return productRepository.save(product);
	}
	
	
}
