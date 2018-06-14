package com.alibaba.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.entity.Comment;
import com.alibaba.entity.Goods;
import com.alibaba.entity.GoodsDetail;
import com.alibaba.entity.GoodsImg;
import com.alibaba.entity.GoodsInfo;
import com.alibaba.entity.GoodsPrice;
import com.alibaba.entity.SensitiveWord;
import com.alibaba.entity.SortedGoodsInfo;
import com.alibaba.mapper.GoodsImgMapper;
import com.alibaba.mapper.GoodsMapper;
import com.alibaba.mapper.GoodsPriceMapper;
import com.alibaba.mapper.SensitiveWordMapper;
import com.alibaba.service.GoodsService;
import com.alibaba.util.GoodsUtil;
import com.alibaba.util.SensitiveWordUtil;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsPriceMapper priceMapper;
	@Autowired
	private GoodsImgMapper imgMapper;
	@Autowired
	private SensitiveWordMapper wordMapper;

	@Autowired
	private GoodsMapper goodsMapper;

	public GoodsDetail getGoodsDetail(int id) {

		List<Goods> goods = goodsMapper.queryGoodsById(id);
		List<GoodsImg> image = imgMapper.queryAllImg(id);
		List<GoodsPrice> prcs = priceMapper.queryAllPrices(id);
		for (GoodsPrice p : prcs) {
			StringBuilder type = new StringBuilder(p.getType());
			type.insert(1, "G");
			type.insert(type.length(), "G");
			p.setType(type.toString());
		}
		// PrintInfo(goods, image, prcs);
		return new GoodsDetail(goods, image, prcs);
	}

	@Override
	public GoodsInfo displayGoods() {
		Set<GoodsPrice> prices;
		Set<GoodsImg> img;
		List<Goods> goods;
		GoodsUtil goodsUtils = GoodsUtil.UTIL;
		GoodsInfo goodsInfo = null;

		prices = goodsUtils.getPrices();
		img = goodsUtils.getImg();
		goods = goodsUtils.getGoods();

		if (goods != null && prices != null && img != null) {
			goodsInfo = new GoodsInfo(prices, img, goods);
		} else {
			prices = priceMapper.queryGoodsPrice();
			img = imgMapper.queryGoodsImg();
			goods = goodsMapper.queryGoods();
			goodsInfo = new GoodsInfo(prices, img, goods);
			goodsUtils.setInfo(goodsInfo);
		}
		return goodsInfo;
	}

	@Override
	public SortedGoodsInfo orderByPrice() {
		// 获取商品信息
		GoodsInfo info = displayGoods();
		Set<GoodsPrice> prices = info.getPrices();
		List<Goods> goods = info.getGoods();
		Set<GoodsImg> image = info.getImg();
		// 将Set转为List，用于排序
		List<GoodsPrice> prcs = new LinkedList<GoodsPrice>(prices);
		// 按照price升序排序
		Collections.sort(prcs, new Comparator<GoodsPrice>() {

			@Override
			public int compare(GoodsPrice o1, GoodsPrice o2) {
				if (o1.getPrice() > o2.getPrice()) {
					return 1;
				} else if (o1.getPrice() == o2.getPrice()) {
					return 0;
				}
				return -1;
			}

		});
		return moveElementsToNewCollection(goods, image, prcs);

	}

	public static void PrintInfo(Goods[] goodsArray, GoodsImg[] imgArray, List<GoodsPrice> prcs) {
		System.out.println(" \n \n---------------Service PrintInfo  begin-------------------------");

		System.out.println("goods:");
		for (Goods g : goodsArray) {
			System.out.println(g);
		}

		System.out.println("\n\nImg:");
		for (GoodsImg i : imgArray) {
			System.out.println(i);
		}

		System.out.println("\n\nprice:");
		for (GoodsPrice p : prcs) {
			System.out.println(p);
		}
		System.out.println("--------------PrintInfo  end-------------------------");
	}

	@Override
	public SortedGoodsInfo orderBySalesVolume() {
		// 获取商品信息
		GoodsInfo info = displayGoods();
		Set<GoodsPrice> prices = info.getPrices();
		List<Goods> goods = info.getGoods();
		Set<GoodsImg> image = info.getImg();
		// 将Set转为List，用于排序
		List<GoodsPrice> prcs = new LinkedList<GoodsPrice>(prices);
		// 按照SlaesVolume升序排序
		Collections.sort(prcs, new Comparator<GoodsPrice>() {

			@Override
			public int compare(GoodsPrice o1, GoodsPrice o2) {
				if (o1.getSalesVolume() > o2.getSalesVolume()) {
					return 1;
				} else if (o1.getSalesVolume() == o2.getSalesVolume()) {
					return 0;
				}
				return -1;
			}

		});
		return moveElementsToNewCollection(goods, image, prcs);

	}

	public SortedGoodsInfo moveElementsToNewCollection(List<Goods> goods, Set<GoodsImg> image, List<GoodsPrice> prcs) {// 根据prcs对goods集合和image集合进行调整，使其goodsId的顺序一致
		Goods[] goodsArray = new Goods[goods.size()];
		GoodsImg[] imgArray = new GoodsImg[image.size()];
		int goodsIndex = 0;
		int imgIndex = 0;
		for (GoodsPrice p : prcs) {
			int id = p.getGoodsId();
			// 将goods中的元素转到goodsArray中
			for (Goods g : goods) {
				if (g.getId() == id) {
					goodsArray[goodsIndex++] = g;
				}
			}
			// 将image中的元素转到imgArray中
			for (GoodsImg i : image) {
				if (i.getGoodsId() == id) {
					imgArray[imgIndex++] = i;
				}
			}

		}
		image = null;// Let GC do it's work
		goods = null;
		List<Goods> g = Arrays.asList(goodsArray);
		List<GoodsImg> img = Arrays.asList(imgArray);
		// System.out.println("\n\nImgIndex:" + imgIndex + " goodsIndex:" + goodsIndex +
		// "\n");
		// PrintInfo(g, img, prcs);
		// System.out.println(" \n \n---------------moveElementsToNewCollection
		// end-------------------------");
		return new SortedGoodsInfo(g, img, prcs);
	}

	@Override
	public SortedGoodsInfo fuzzyQueryGoods(String param) {
		// 根据字符串模糊查询商品
		List<Goods> goods = goodsMapper.fuzzyQueryGoods(param);
		// GoodsUtil goodsUtil = GoodsUtil.UTIL;
		Set<GoodsPrice> prices = priceMapper.queryGoodsPrice();
		Set<GoodsImg> img = imgMapper.queryGoodsImg();
		// if (img == null) {
		// img = imgMapper.queryGoodsImg();
		//// goodsUtil.setImg(img);
		// }
		// if (prices == null) {
		// prices = priceMapper.queryGoodsPrice();
		//// goodsUtil.setPrices(prices);
		// }
		// 保留在goods中存在的商品
		retain(prices, img, goods);
		return moveElementsToNewCollection(goods, img, new LinkedList<GoodsPrice>(prices));
	}

	private void retain(Set<GoodsPrice> prices, Set<GoodsImg> img, List<Goods> goods) {

		// fail-fast,应使用迭代器
		// for (GoodsPrice p : prices) {
		// int id = p.getGoodsId();
		// boolean priceFlag = false;
		// for (Goods g : goods) {
		// if (g.getId() == id) {
		// priceFlag = true;
		// break;
		// }
		// }
		// if (!priceFlag) {
		// prices.remove(p);
		// }
		// }

		Iterator<GoodsPrice> it = prices.iterator();
		while (it.hasNext()) {
			GoodsPrice p = it.next();
			int id = p.getGoodsId();
			boolean flag = false;
			for (Goods g : goods) {
				if (g.getId() == id) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				it.remove();
			}

		}

		Iterator<GoodsImg> imgIt = img.iterator();
		while (imgIt.hasNext()) {
			GoodsImg i = imgIt.next();
			int id = i.getGoodsId();
			boolean flag = false;
			for (Goods g : goods) {
				if (g.getId() == id) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				imgIt.remove();
			}

		}

		// for (GoodsImg i : img) {
		// int id = i.getGoodsId();
		// boolean flag = false;
		// for (Goods g : goods) {
		// if (g.getId() == id) {
		// flag = true;
		// break;
		// }
		// }
		// if (!flag) {
		// img.remove(i);
		// }
		// }
		// PrintInfo(goods, img, prices);
	}

	@Override
	public SortedGoodsInfo orderByPriceDecline() {
		// 获取商品信息
		GoodsInfo info = displayGoods();
		Set<GoodsPrice> prices = info.getPrices();
		List<Goods> goods = info.getGoods();
		Set<GoodsImg> image = info.getImg();
		// 将Set转为List，用于排序
		List<GoodsPrice> prcs = new LinkedList<GoodsPrice>(prices);
		// 按照price降序排序
		Collections.sort(prcs, new Comparator<GoodsPrice>() {

			@Override
			public int compare(GoodsPrice o1, GoodsPrice o2) {
				if (o1.getPrice() > o2.getPrice()) {
					return -1;
				} else if (o1.getPrice() == o2.getPrice()) {
					return 0;
				}
				return 1;
			}

		});
		return moveElementsToNewCollection(goods, image, prcs);
	}

	@Override
	public SortedGoodsInfo orderBySalesVolumeDecline() {
		// 获取商品信息
		GoodsInfo info = displayGoods();
		Set<GoodsPrice> prices = info.getPrices();
		List<Goods> goods = info.getGoods();
		Set<GoodsImg> image = info.getImg();
		// 将Set转为List，用于排序
		List<GoodsPrice> prcs = new LinkedList<GoodsPrice>(prices);
		// 按照SlaesVolume降序排序
		Collections.sort(prcs, new Comparator<GoodsPrice>() {

			@Override
			public int compare(GoodsPrice o1, GoodsPrice o2) {
				if (o1.getSalesVolume() > o2.getSalesVolume()) {
					return -1;
				} else if (o1.getSalesVolume() == o2.getSalesVolume()) {
					return 0;
				}
				return 1;
			}

		});
		return moveElementsToNewCollection(goods, image, prcs);
	}

	// 1:包含敏感词
	// -1:已经评论
	// 0:OK
	@Override
	public int addComment(int goodsId, int userId, String content) {
		// 判断是否已经评论
		List<Comment> comments = goodsMapper.selectCommentByGoodsIdAndUserId(goodsId, userId);
		System.out.println("\n\n\ncomments:" + comments);
		if (null != comments && comments.size() > 0) {
			return -1;
		} else if (filtrateSensitiveword(content)) {
			// 包含敏感词
			return 1;
		}
		Comment c = new Comment(userId, goodsId, content);
		if (content != null) {
			goodsMapper.insertComment(c);
		}
		// 评论成功
		return 0;
	}

	boolean filtrateSensitiveword(String content) {
		List<SensitiveWord> words = SensitiveWordUtil.words;
		if (words == null) {
			words = wordMapper.queryWord();
			SensitiveWordUtil.setWords(words);
		}
		if (content != null) {
			for (SensitiveWord w : words) {
				if (content.indexOf(w.getWord()) != -1) {
					// 包含敏感词
					return true;
				}
			}
		}
		// 不包含敏感词
		return false;
	}
}
