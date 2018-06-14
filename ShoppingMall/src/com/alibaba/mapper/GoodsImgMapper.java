package com.alibaba.mapper;


import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.alibaba.entity.GoodsImg;

@Repository
public interface GoodsImgMapper {
	
	Set<GoodsImg> queryGoodsImg();
	
	List<GoodsImg> queryAllImg(@Param("id")  int id);
	

}
