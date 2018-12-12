package com.wit.cart.witcart.service;

import com.wit.cart.witcart.mapper.RedisMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class CartService {

    private RedisMapper redisMapper;

    public CartService() {
        this.redisMapper = new RedisMapper();
    }


    public String fetchItem(int itemId, int customerId) {

        try {

            URL url = new URL("http://localhost:8081/catalog-service/get-item?id=1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            System.out.println(connection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //need one more request to verify customerId is valid or not

        return redisMapper.addItemToCart(itemId, customerId);

    }

    public String deleteItemFromCart(String itemId) {
        return redisMapper.deleteItemFromCart(itemId);
    }

    public String viewItemFromCart() {
        return redisMapper.viewItemsFromCart();
    }
}
