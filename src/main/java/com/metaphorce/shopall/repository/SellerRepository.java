package com.metaphorce.shopall.repository;

import com.metaphorce.shopall.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

    Seller findByPhoneNumber(String phoneNumber);

}
