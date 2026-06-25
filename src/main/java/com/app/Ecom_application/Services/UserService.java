package com.app.Ecom_application.Services;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.Ecom_application.DTO.AddressDTO;
import com.app.Ecom_application.DTO.UserRequest;
import com.app.Ecom_application.DTO.UserResponse;
import com.app.Ecom_application.Enities.Address;
import com.app.Ecom_application.Enities.User;
import com.app.Ecom_application.Repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService 
{
   private final UserRepository userRepo;
   public List<UserResponse> featchUsers()
   {
     return  userRepo.findAll().stream()
     .map(this::mapUserResponse).collect(Collectors.toList()); 
   }
   public Optional<User> getUserById(Long id)
   {
      return userRepo.findById(id);
   }
   public User   createUser(UserRequest userRequest)
   {  
        User user= new User();
        updateUserFromRequest(user,userRequest); 
       return  userRepo.save(user);
   }
   public Optional<User> updatedUser(UserRequest updatUserRequest, Long id)
   {
        return  userRepo.findById(id)
         .map(existingUser->{
             updateUserFromRequest(existingUser, updatUserRequest);
            userRepo.save(existingUser);
            return existingUser;
         });  

   }
   public void  deleteUser(Long Id)
   {
       userRepo.deleteById(Id); 
   }
   private UserResponse mapUserResponse(User user)
   {
      UserResponse userResponses=new  UserResponse();
      userResponses.setId(user.getId().toString());
      userResponses.setFirstName(user.getFirstName());
      userResponses.setLastName(user.getLastName());
      userResponses.setMail(user.getMail());
      userResponses.setPhone(user.getPhone());
      userResponses.setUserRoleConstants(user.getRole());
        Optional.ofNullable(user.getAddress())
            .ifPresent(address -> {
                AddressDTO dto = new AddressDTO();
                dto.setCity(address.getCity());
                dto.setCountry(address.getCountry());
                dto.setDistrict(address.getDistrict());
                dto.setStreat(address.getStreat());
                dto.setZipCode(address.getZipCode());

                userResponses.setAddressDTO(dto);
            });
      
      return userResponses;
   }
   private void  updateUserFromRequest(User user, UserRequest userRequest)
   {
      user.setFirstName(userRequest.getFirstName());
      user.setLastName(userRequest.getLastName());
      user.setMail(userRequest.getMail());
      user.setPhone(userRequest.getPhone());
      Optional.ofNullable(userRequest.getAddress())
            .ifPresent(address -> {
                Address add=new Address();
                add.setCity(address.getCity());
                add.setCountry(address.getCountry());
                add.setDistrict(address.getDistrict());
                add.setStreat(address.getStreat());
                add.setZipCode(address.getZipCode());

                user.setAddress(add);
            });

   }
}
