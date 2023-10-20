package com.metaphorce.shopall.repository;

import com.metaphorce.shopall.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
    Buyer findByEmail(String email);

}
