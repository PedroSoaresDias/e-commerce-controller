package com.dev.warehouse.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.warehouse.domain.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
