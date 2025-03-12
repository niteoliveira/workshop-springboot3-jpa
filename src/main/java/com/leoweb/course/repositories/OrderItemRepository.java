package com.leoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leoweb.course.entities.OrderItem;
import com.leoweb.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
