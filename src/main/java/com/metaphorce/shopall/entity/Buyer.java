package com.metaphorce.shopall.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "buyers")
@Data
@NoArgsConstructor
public class Buyer extends User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

}
