package com.app.Ecom_application.Enities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.app.Ecom_application.Helper.UserRoleConstants;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity(name = "user_table")
public class User 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id ;
 private String firstName ;
 private String lastName ;
 private String mail;
 private String phone;
 private  UserRoleConstants role=UserRoleConstants.CUSTOEMR;
 @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name = "address_id", referencedColumnName = "id")
 @Nonnull
 private Address address;
 @CreationTimestamp
 private LocalDateTime createdDateTime;
 @UpdateTimestamp
 private LocalDateTime upDateTime;
}
