package com.wit.cart.witcart.service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class CartService {
    public String fetchItemsInCart(){
        return (new Jedis("localhost").smembers("item_set").toString());
    }
}
