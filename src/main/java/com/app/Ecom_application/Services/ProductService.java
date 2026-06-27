package com.app.Ecom_application.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.app.Ecom_application.DTO.ProductRequest;
import com.app.Ecom_application.Enities.Product;
import com.app.Ecom_application.Repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ProductService 
{
   // if we are user RequiredArgsConstructor than we need to create our variable/objects as final
  private final  ProductRepository productRepository;
 
  public Product createProduct(ProductRequest createRequest)
  {
    Product createdProduct=new Product();
       mapProductFromRequest(createdProduct,createRequest);
       productRepository.save(createdProduct);
       return createdProduct;
  }
  public List<Product> fetchProduct()
  {
        return  productRepository.findAll().stream()   //findAll kabhi null value resturns nahi karta ye return karta hia null or []
        .map(this::mapProductResponse).collect(Collectors.toList());
  }
  public Optional<Product> updateProduct(Long id, ProductRequest productRequest)
  {
    return productRepository.findById(id)
    .map(existingProduct->{
        mapProductFromRequest(existingProduct, productRequest);
        productRepository.save(existingProduct);
        return existingProduct;
    });
  }
  public Optional<Product> getProduct(Long id)
  {
    return productRepository.findById(id);
  }
  private void mapProductFromRequest(Product newProduct,ProductRequest request)
  {
      newProduct.setName(request.getName());
      newProduct.setCategory(request.getCategory());
      newProduct.setDescription(request.getDescription());
    //   write code  latter for creating  
  }
  public void deleteProduct(Long id)
  {
    productRepository.deleteById(id);
  }
  private Product mapProductResponse(Product responseproduct)
  {
        Product product=new Product();
        product.setName(responseproduct.getName());
        product.setCategory(responseproduct.getCategory());
        product.setCreatedTime(responseproduct.getCreatedTime());
        product.setUpDateTime(responseproduct.getUpDateTime());
        product.setId(responseproduct.getId());
        product.setDescription(responseproduct.getDescription());
        product.setImageUrl(responseproduct.getImageUrl());
        product.setActive(responseproduct.isActive());
        return product;
  }
}
