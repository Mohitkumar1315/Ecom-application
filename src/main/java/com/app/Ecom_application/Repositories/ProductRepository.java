package com.app.Ecom_application.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;
import com.app.Ecom_application.Enities.Product;
public interface ProductRepository extends JpaRepository<Product,Long>
{
    List<Product> findByisActiveTrue();
    @Query("select p from EcomProduct p where p.stockQuantity>0 and p.isActive=true and LOWER(p.name) like LOWER(CONCAT('%',:keyword ,'%'))")
    List<Product> serachProducts(@Param("keyword") String keyword);
}
    