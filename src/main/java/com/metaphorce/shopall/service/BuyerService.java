package com.metaphorce.shopall.service;

import com.metaphorce.shopall.entity.Buyer;
import com.metaphorce.shopall.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    public Buyer createBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public Buyer getById(Integer id) {
        return buyerRepository.findById(id).orElse(null);
    }

    public Buyer getByEmail(String email) {
        return buyerRepository.findByEmail(email);
    }

    public void deleteBuyer(Integer id) {
        buyerRepository.deleteById(id);
    }

    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    public Buyer updateBuyer(Integer id, Buyer updatedBuyer) {
        Buyer buyer = buyerRepository.findById(id).orElse(null);
        if(buyer != null) {
            buyer.setFirstName(updatedBuyer.getFirstName());
            buyer.setLastName(updatedBuyer.getLastName());
            buyer.setEmail(updatedBuyer.getEmail());
            buyer.setPassword(updatedBuyer.getPassword());
            return buyerRepository.save(buyer);
        }
        return null;
    }

}
