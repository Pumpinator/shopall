package com.metaphorce.shopall.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "sellers")
@Data
@NoArgsConstructor
public class Seller extends User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

}
