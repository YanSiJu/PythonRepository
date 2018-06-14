package com.alibaba.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.alibaba.entity.GoodsInOrder;
import com.alibaba.entity.Order;

@Repository
public interface OrderMapper {

	void insertOrder(Order o);

	void insertGoods(GoodsInOrder goods);

	List<Order> selectOrderById(@Param("id")int id);

}
