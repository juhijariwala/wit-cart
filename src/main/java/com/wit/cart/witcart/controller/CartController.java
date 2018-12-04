package com.wit.cart.witcart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CartController {
    @GetMapping("cart")
    public ResponseEntity proceedToCart(@RequestParam String item_id){
        return ResponseEntity.ok().body("items");
    }
}
