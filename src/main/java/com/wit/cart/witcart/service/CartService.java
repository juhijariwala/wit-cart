package com.wit.cart.witcart.service;

import com.wit.cart.witcart.mapper.CartMapper;
import com.wit.cart.witcart.mapper.MyBatisUtil;
import com.wit.cart.witcart.model.Item;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;


@Service
public class CartService {
        private CartMapper cartMapper;
        private SqlSession sqlSession;

    public CartService() {
            this(MyBatisUtil.getSqlSessionFactory().openSession());
        }

    public CartService(SqlSession sqlSession) {
            this.sqlSession= sqlSession;
            this.cartMapper = sqlSession.getMapper(CartMapper.class);
        }


        public Item fetchItem(String itemId) {
            Item item = cartMapper.fetchItem(itemId);
            sqlSession.commit();
            return item;
        }
}
