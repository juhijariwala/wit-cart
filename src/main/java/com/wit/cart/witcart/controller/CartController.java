package com.wit.cart.witcart.controller;

import com.wit.cart.witcart.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {
    private CartService cartService = new CartService();

    @PostMapping("add")
    public ResponseEntity proceedToCart(@RequestParam int itemId, @RequestParam int customerId) {
        return ResponseEntity.ok().body(cartService.fetchItem(itemId, customerId));
    }

    @GetMapping("remove")
    public ResponseEntity removeItemFromCart(@RequestParam String itemId) {
        return ResponseEntity.ok().body(cartService.deleteItemFromCart(itemId));
    }

    @GetMapping("view")
    public ResponseEntity viewItemsInCart() {
        return ResponseEntity.ok().body(cartService.viewItemFromCart());
    }
}
