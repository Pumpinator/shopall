package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.entity.Product;
import com.metaphorce.shopall.entity.Buyer;
import com.metaphorce.shopall.service.BuyerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyers")
@Tag(name = "Buyers")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @Operation(summary = "Create a new buyer")
    @PostMapping("/create")
    public Buyer createBuyer(@RequestBody Buyer buyer) {
        return buyerService.createBuyer(buyer);
    }

    @Operation(summary = "Get a buyer by ID")
    @GetMapping("/{id}")
    public Buyer getBuyerById(@PathVariable Integer id) {
        return buyerService.getById(id);
    }

    @Operation(summary = "Find a buyer by email")
    @GetMapping("/findByEmail")
    public Buyer getBuyerByEmail(@RequestParam String email) {
        return buyerService.getByEmail(email);
    }

    @Operation(summary = "Delete a buyer by ID")
    @DeleteMapping("/{id}")
    public void deleteBuyer(@PathVariable Integer id) {
        buyerService.deleteBuyer(id);
    }

    @Operation(summary = "Get all buyers")
    @GetMapping("/getAll")
    public List<Buyer> getAllBuyers() {
        return buyerService.getAllBuyers();
    }

    @Operation(summary = "Update a buyer by ID")
    @PutMapping("/{id}")
    public Buyer updateBuyer(@PathVariable Integer id, @RequestBody Buyer updatedBuyer) {
        return buyerService.updateBuyer(id, updatedBuyer);
    }

}
