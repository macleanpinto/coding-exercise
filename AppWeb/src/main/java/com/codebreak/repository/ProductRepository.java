package com.codebreak.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.codebreak.documents.Product;

@Transactional
public interface ProductRepository extends MongoRepository<Product, String> {

}