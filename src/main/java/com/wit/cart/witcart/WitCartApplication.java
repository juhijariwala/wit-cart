package com.wit.cart.witcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class WitCartApplication {
	public static void main(String[] args) {
		Jedis client = new Jedis("localhost");
		client.flushDB();
		SpringApplication.run(WitCartApplication.class, args);
	}
}
