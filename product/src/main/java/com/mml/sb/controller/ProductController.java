package com.mml.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mml.sb.model.Product;
import com.mml.sb.service.ProductService;

@Controller
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	

	@GetMapping(path="/products")
	private String retrieveAllProduct(Model model) {
	
		var products = productService.findAll();
		
		model.addAttribute("products", products);
		
		return "product.html";
	}

	@PostMapping(path="/products")
	private String addProduct(@RequestParam String name, @RequestParam double price, Model model) {
	
		var product = new Product(name, price);
				
		productService.addProduct(product);		
		
		model.addAttribute("products", productService.findAll());
		
		return "product.html";
	}

}
