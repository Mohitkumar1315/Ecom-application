package com.app.Ecom_application.DTO;
import com.app.Ecom_application.Helper.UserRoleConstants;

import lombok.Data;

@Data
public class UserResponse 
{
    private String id ;
 private String firstName ;
 private String lastName ;
 private String mail;
 private String phone;
 private UserRoleConstants userRoleConstants;
 private AddressDTO addressDTO;

}
