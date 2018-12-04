package com.wit.cart.witcart.controller;

import com.wit.cart.witcart.model.Item;
import com.wit.cart.witcart.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping("add")
    public ResponseEntity proceedToCart(@RequestParam String itemId){
        CartService cartService = new CartService();
        Item item = cartService.fetchItem(itemId);
        Jedis client = new Jedis("localhost");
        if (item!=null){
            client.hset("item_hashMap",itemId,item.toString());
        }
        return ResponseEntity.ok().body(client.hgetAll("item_hashMap"));
    }
    @GetMapping("remove")
    public ResponseEntity removeItemFromCart(@RequestParam String itemId){
        Jedis client = new Jedis("localhost");
        if (client.hexists("item_hashMap",itemId)){
            client.hdel("item_hashMap",itemId);
        }
        return ResponseEntity.ok().body(client.hgetAll("item_hashMap"));
    }
    @GetMapping("view")
    public ResponseEntity viewItemsInCart(){
        Jedis client = new Jedis("localhost");
        return ResponseEntity.ok().body(client.hgetAll("item_hashMap"));
    }
}
