package com.app.Ecom_application.controller;
import com.app.Ecom_application.Services.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.Ecom_application.DTO.ProductRequest;
import com.app.Ecom_application.Enities.Product;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@RequestMapping("/ecom")
public class ProductController 
{
   @Autowired
    private ProductService productService;     
    @RequestMapping(value = "/Product-test", method=RequestMethod.GET)
     public String requestMethodName() 
     {
         return "This is a Product-Controller";
     }
     @PostMapping("/create-product")
     public ResponseEntity<String> postMethodName(@RequestBody ProductRequest productRequest) 
     {      
         return  Optional.ofNullable(productService.createProduct(productRequest))
         .map(savedProduct->
            ResponseEntity.ok().body("Product creted successfully")
         ).orElse(ResponseEntity.internalServerError().body("Please check request"));
     }
     @GetMapping("/products")
     public ResponseEntity<List<Product>> getProducts() 
     {
        return Optional.ofNullable(productService.fetchProduct())
        .filter(products->!products.isEmpty())
        .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
     }
         
}
