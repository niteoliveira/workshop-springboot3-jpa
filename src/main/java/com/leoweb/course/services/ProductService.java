package com.leoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leoweb.course.entities.Product;
import com.leoweb.course.repositories.ProductRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private EntityManager entityManager;  // Injetando o EntityManager
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
	@Transactional
    public void performOperation() {
        
        Product Product = entityManager.find(Product.class, 1L);
        
       
        entityManager.refresh(Product);
        
       
        Product.setName("Updated Name");
        
   
        entityManager.merge(Product);
    }
}
