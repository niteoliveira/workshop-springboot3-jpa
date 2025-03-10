package com.leoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leoweb.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
