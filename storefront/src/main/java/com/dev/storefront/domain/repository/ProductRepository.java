package com.dev.storefront.domain.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.storefront.domain.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByActiveTrueOrderByNameAsc();
}
