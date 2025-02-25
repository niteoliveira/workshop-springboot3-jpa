package com.leoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.leoweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
