package com.wit.cart.witcart.controller;

import com.wit.cart.witcart.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("/")
public class CartController {
    @GetMapping("cart")
    public ResponseEntity proceedToCart(@RequestParam String item_id){
        Jedis client = new Jedis("localhost");
        client.sadd("item_set",item_id);
        return ResponseEntity.ok().body(new CartService().fetchItemsInCart());
    }
}
