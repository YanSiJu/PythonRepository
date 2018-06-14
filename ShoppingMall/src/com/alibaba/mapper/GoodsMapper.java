package com.alibaba.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.alibaba.entity.Comment;
import com.alibaba.entity.Goods;

@Repository
public interface GoodsMapper {

	List<Goods> queryGoods();

	void insertComment(Comment c);

	List<Comment> selectCommentByGoodsId(@Param("goodsId") int goodsId);

	List<Comment> selectCommentByGoodsIdAndUserId(@Param("goodsId") int goodsId, @Param("userId") int userId);

	List<Goods> fuzzyQueryGoods(@Param("param") String param);

	List<Goods> queryGoodsById(@Param("id") int id);

	void updateSalesVolume(@Param("number") int number, @Param("type") String type, @Param("goodsId") int goodsId);

}
