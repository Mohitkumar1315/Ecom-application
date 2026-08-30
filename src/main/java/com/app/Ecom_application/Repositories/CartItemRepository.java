package com.app.Ecom_application.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.Ecom_application.Enities.CartItem;
public interface CartItemRepository extends JpaRepository<CartItem,Long>
{

}
