package com.wit.cart.witcart.mapper;

import redis.clients.jedis.Jedis;

public class RedisMapper {
    private Jedis client;

    public RedisMapper() {
        this.client = new Jedis("localhost");
    }

    public String addItemToCart(int itemId, int customerId) {
        //need to add that response in redis with customerId
        return client.hgetAll("item_hashMap").toString();
    }

    public String deleteItemFromCart(String itemId) {
        if (client.hexists("item_hashMap", itemId)) {
            client.hdel("item_hashMap", itemId);
        }
        return client.hgetAll("item_hashMap").toString();
    }

    public String viewItemsFromCart() {
        return client.hgetAll("item_hashMap").toString();
    }
}
