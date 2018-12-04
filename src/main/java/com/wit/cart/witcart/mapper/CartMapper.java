package com.wit.cart.witcart.mapper;

import com.wit.cart.witcart.model.Item;
import org.apache.ibatis.annotations.Select;


public interface CartMapper {
    @Select(
            "SELECT id, name, price, description FROM items WHERE id=#{id}"
    )
    Item fetchItem(String id);
}
