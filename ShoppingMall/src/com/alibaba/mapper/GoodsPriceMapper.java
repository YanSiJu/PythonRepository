package com.alibaba.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.alibaba.entity.GoodsPrice;

@Repository
public interface GoodsPriceMapper {

	Set<GoodsPrice> queryGoodsPrice();

	List<GoodsPrice> queryAllPrices(@Param("id") int id);

	List<GoodsPrice> queryPricesByIdAndType(@Param("id") int id, @Param("type") String type);

}
