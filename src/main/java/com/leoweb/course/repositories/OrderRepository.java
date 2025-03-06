package com.leoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leoweb.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
