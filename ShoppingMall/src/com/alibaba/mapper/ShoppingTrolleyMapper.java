package com.alibaba.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.alibaba.entity.ShoppingTrolley;
import com.alibaba.entity.goodsInShoppingtrolley;

@Repository
public interface ShoppingTrolleyMapper {

	void createShoppingTrolley(ShoppingTrolley trolley);

	List<ShoppingTrolley> queryShoppingTrolley(@Param("userId") int userId);
	
	
	List<goodsInShoppingtrolley> queryTrolleyByTrolleyId(@Param("trolleyId") int trolleyId);

	List<goodsInShoppingtrolley> queryShoppingTrolleyByPK(@Param("goodsId") int goodsId,
			@Param("shoppingtrolleyId") int shoppingtrolleyId);

	void insertGoods(goodsInShoppingtrolley trolley);

	void updateGoods(goodsInShoppingtrolley trolley);

	void updateGoodsQuantity(@Param("number") int number, @Param("amount") double amount,
			@Param("shoppingtrolleyId") int shoppingtrolleyId,  @Param("goodsId") int goodsId);
	
	void update(@Param("number") int number, @Param("amount") double amount,
			@Param("shoppingtrolleyId") int shoppingtrolleyId,  @Param("goodsId") int goodsId);

	void deleteGoods(@Param("goodsId") int goodsId, @Param("shoppingtrolleyId") int shoppingtrolleyId);
}
