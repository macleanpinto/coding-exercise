package com.codebreak.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebreak.documents.Product;
import com.codebreak.repository.ProductRepository;

@RestController
public class ProductInfo {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/fetchProducts")
	public List<Product> greeting() {
		System.out.println(productRepository);

		return productRepository.findAll();
	}

}
