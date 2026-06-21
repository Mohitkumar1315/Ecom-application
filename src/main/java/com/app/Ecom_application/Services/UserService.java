package com.app.Ecom_application.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.Ecom_application.Enities.User;
import com.app.Ecom_application.Repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService 
{
   private final UserRepository userRepo;
   public List<User> featchUsers()
   {
     return  userRepo.findAll(); 
   }
   public Optional<User> getUserById(Long id)
   {
      return userRepo.findById(id);
   }
   public User   createUser(User user)
   {  
      return  userRepo.save(user);
   }
   public Optional<User> updatedUser(User updatedUserDetails, Long id)
   {
        return  userRepo.findById(id)
         .map(existingUser->{
            existingUser.setFirstName(updatedUserDetails.getFirstName());
            existingUser.setLastName(updatedUserDetails.getLastName());
            System.out.println(existingUser.toString());
            return existingUser;
         });  

   }
   public void  deleteUser(Long Id)
   {
       userRepo.deleteById(Id); 
   }
}
