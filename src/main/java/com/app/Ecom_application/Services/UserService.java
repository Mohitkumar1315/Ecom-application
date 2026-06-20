package com.app.Ecom_application.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.Ecom_application.Enities.User;

@Service
public class UserService 
{
    List<User> userList=new ArrayList<>();
    private Long userid= 1L;
   public List<User> featchUsers()
   {
     return  userList;      
   }
   public Optional<User> getUserById(Long id)
   {
      return userList.stream()
      .filter(user->user.getId().equals(id)).findFirst();
   }
   public List<User> createUser(User user)
   {  
        user.setId(userid++);
        userList.add(user);
        return   userList;
   }
   public Optional<User> updatedUser(User updatedUserDetails, Long id)
   {
      return userList.stream()
            .filter(user -> user.getId().equals(id))
            .findFirst()
            .map(existingUser -> {

                existingUser.setFirstName(updatedUserDetails.getFirstName());
                existingUser.setLastName(updatedUserDetails.getLastName());

                return existingUser;
            });

   }
   public Optional<User> deleteUser(Long Id)
   {
      return getUserById(Id)
      .map(user->{
         userList.remove(user);
         return user;
      }); 
   }
}
