package com.metaphorce.shopall.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String email;

    @Column(name = "password")
    private String password;

}
