package com.app.Ecom_application.controller;

import org.springframework.web.bind.annotation.RestController;

import com.app.Ecom_application.Enities.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController 
{
   List<User> userList = new ArrayList<>();

    @GetMapping("test")
    public String testMethod() {
        return new String("This is testing method of UserController");
    }
    
    @GetMapping("ecom-users")
    public List<User> getUser()
    {
       
        return  userList;
    }
    // @PostMapping("path")
    // public ResponseEntity CreateUser (@RequestBody String entity) {
        
    //   User user=new User();
    //   user.setFirst("Mohit");
    //   user.setLast("Kabir");
    //     return ResponseEntity.status(HttpStatus.OK).body(user);
    // }
    @PostMapping("create/user")
    public List<User> CreateUser (@RequestBody User user) {
        System.out.println("User is :"+user);
         userList.add(user);
         return userList;
      
    }
}
