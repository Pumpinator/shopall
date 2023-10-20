package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.entity.Category;
import com.metaphorce.shopall.entity.Seller;
import com.metaphorce.shopall.service.SellerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
@Tag(name = "Sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Operation(summary = "Create a new seller")
    @PostMapping("/create")
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.createSeller(seller);
    }

    @Operation(summary = "Get a seller by ID")
    @GetMapping("/{id}")
    public Seller getSellerById(@PathVariable Integer id) {
        return sellerService.getById(id);
    }

    @Operation(summary = "Find a buyer by email")
    @GetMapping("/findByPhoneNumber")
    public Seller getSellerByName(@RequestParam String phoneNumber) {
        return sellerService.getByPhoneNumber(phoneNumber);
    }

    @Operation(summary = "Delete a seller by ID")
    @DeleteMapping("/{id}")
    public void deleteSeller(@PathVariable Integer id) {
        sellerService.deleteSeller(id);
    }

    @Operation(summary = "Get all sellers")
    @GetMapping("/getAll")
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @Operation(summary = "Update a seller by ID")
    @PutMapping("/{id}")
    public Seller updateBuyer(@PathVariable Integer id, @RequestBody Seller updatedSeller) {
        return sellerService.updateSeller(id, updatedSeller);
    }

}
