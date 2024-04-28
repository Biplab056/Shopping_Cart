package com.jsp.ShoppingCart.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ShoppingCart.DTO.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{

}
