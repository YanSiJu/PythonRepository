package com.alibaba.service;

import org.springframework.stereotype.Service;

import com.alibaba.entity.GoodsInfo;
import com.alibaba.entity.SortedGoodsInfo;

@Service
public interface GoodsService {

	GoodsInfo displayGoods();

	int addComment(int goodsId, int userId, String content);

	SortedGoodsInfo orderByPrice();

	SortedGoodsInfo orderBySalesVolume();

	SortedGoodsInfo orderByPriceDecline();

	SortedGoodsInfo orderBySalesVolumeDecline();

	SortedGoodsInfo fuzzyQueryGoods(String param);

}
