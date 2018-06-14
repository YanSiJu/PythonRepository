package com.alibaba;

import org.junit.Test;
import com.alibaba.service.impl.GoodsServiceImpl;

public class GoodsServiceImplTest {

	@Test
	public void testDisplayGoods() {
		new GoodsServiceImpl().displayGoods();;
	}

}
