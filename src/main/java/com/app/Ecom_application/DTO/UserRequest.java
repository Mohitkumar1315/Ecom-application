package com.app.Ecom_application.DTO;
import com.app.Ecom_application.Enities.Address;

import lombok.Data;
@Data
public class UserRequest
{
 private String firstName ;
 private String lastName ;
 private String mail;
 private String phone;
 private Address address;
}
