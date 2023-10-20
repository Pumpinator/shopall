package com.metaphorce.shopall.service;

import com.metaphorce.shopall.entity.Seller;
import com.metaphorce.shopall.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public Seller createSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public Seller getById(Integer id) {
        return  sellerRepository.findById(id).orElse(null);
    }

    public Seller getByPhoneNumber(String phoneNumber) {
        return sellerRepository.findByPhoneNumber(phoneNumber);
    }

    public void deleteSeller(Integer id) {
        sellerRepository.deleteById(id);
    }

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Seller updateSeller(Integer id, Seller updatedSeller) {
        Seller seller = sellerRepository.findById(id).orElse(null);
        if(seller != null) {
            seller.setFirstName(updatedSeller.getFirstName());
            seller.setLastName(updatedSeller.getLastName());
            seller.setEmail(updatedSeller.getEmail());
            seller.setPassword(updatedSeller.getPassword());
            seller.setName(updatedSeller.getName());
            seller.setPhoneNumber(updatedSeller.getPhoneNumber());
            return sellerRepository.save(seller);
        }
        return null;
    }

}
