package com.app.Ecom_application.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Ecom_application.Enities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>
{
}
