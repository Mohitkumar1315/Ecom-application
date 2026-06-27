package com.app.Ecom_application.controller;

import org.springframework.web.bind.annotation.RestController;

import com.app.Ecom_application.DTO.UserRequest;
import com.app.Ecom_application.DTO.UserResponse;
import com.app.Ecom_application.Enities.User;
import com.app.Ecom_application.Services.UserService;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
@RestController
@RequiredArgsConstructor
public class UserController 
{

   private final  UserService userService;
   List<User> userList = new ArrayList<>();

    @GetMapping("test")
    public String testMethod() {
        return new String("This is testing method of UserController");
    }
    
    @GetMapping("ecom-users")
    public ResponseEntity<List<UserResponse>> getUser()
    {
        return ResponseEntity.ok(userService.featchUsers());
    }
    @GetMapping("ecom-user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id ) 
    {
     return  userService.getUserById(id).map(ResponseEntity::ok)
     .orElse(ResponseEntity.notFound().build());
    }
    
   @PostMapping("create/user")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest)
    {
       return Optional.ofNullable(userService.createUser(userRequest))
       .map(saveduser->ResponseEntity.ok("User created Successfully"))
       .orElseGet(()->ResponseEntity.badRequest().body("User unable to create"));

    }
    @PutMapping("ecom-user_update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable  Long  id, @RequestBody UserRequest updateUserRequest) 
    {
       return userService.updatedUser(updateUserRequest, id)
       .map(ResponseEntity::ok)
       .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/ecomUser-remove/{id}")
     public ResponseEntity<Void> deleteUser(@PathVariable Long id)
    {
          
          userService.deleteUser(id); 
          return  ResponseEntity.noContent().build(); 
    }
}
