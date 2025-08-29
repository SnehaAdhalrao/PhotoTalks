package com.blogapplication.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapplication.app.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
