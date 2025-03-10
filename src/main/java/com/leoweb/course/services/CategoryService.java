package com.leoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leoweb.course.entities.Category;
import com.leoweb.course.entities.User;
import com.leoweb.course.repositories.CategoryRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private EntityManager entityManager;  // Injetando o EntityManager
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
	@Transactional
    public void performOperation() {
        
        User user = entityManager.find(User.class, 1L);
        
       
        entityManager.refresh(user);
        
       
        user.setName("Updated Name");
        
   
        entityManager.merge(user);
    }
}
