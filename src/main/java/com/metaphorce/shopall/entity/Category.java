package com.metaphorce.shopall.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private List<Product> productList;

}
