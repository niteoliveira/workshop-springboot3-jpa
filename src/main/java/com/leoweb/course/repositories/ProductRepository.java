package com.leoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leoweb.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
