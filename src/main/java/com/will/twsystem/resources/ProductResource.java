package com.will.twsystem.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.will.twsystem.domain.Product;
import com.will.twsystem.services.ProductService;

@Controller
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> find(@PathVariable int id){
		Product obj = productService.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
