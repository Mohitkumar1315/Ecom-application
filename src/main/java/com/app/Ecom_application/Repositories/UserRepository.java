package com.app.Ecom_application.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Ecom_application.Enities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>
{

}
