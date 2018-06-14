package com.alibaba.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.entity.Comment;
import com.alibaba.entity.Goods;
import com.alibaba.entity.GoodsDetail;
import com.alibaba.entity.GoodsImg;
import com.alibaba.entity.GoodsInfo;
import com.alibaba.entity.GoodsPrice;
import com.alibaba.entity.SortedGoodsInfo;
import com.alibaba.entity.User;
import com.alibaba.mapper.GoodsMapper;
import com.alibaba.service.impl.GoodsServiceImpl;

@Controller
@RequestMapping("goods")
public class GoodsController {

	@Autowired
	private GoodsServiceImpl service;

	@Autowired
	private GoodsMapper mapper;

	@RequestMapping("displayGoods")
	public String displayGoods(HttpServletRequest request) {
		// GoodsInfo info = service.displayGoods();
		// HttpSession session = request.getSession();
		// // List list = new ArrayList(new HashSet());
		// List<GoodsPrice> prices = new LinkedList<GoodsPrice>(info.getPrices());
		// session.setAttribute("prices", prices);
		// session.setAttribute("img", info.getImg());
		// session.setAttribute("goods", info.getGoods());
		HttpSession session = request.getSession();
		GoodsInfo info = service.displayGoods();
		List<GoodsPrice> prices = new LinkedList<GoodsPrice>(info.getPrices());
		Set<GoodsImg> image = info.getImg();
		List<Goods> goods = info.getGoods();

		SortedGoodsInfo newInfo = service.moveElementsToNewCollection(goods, image, prices);
		List<GoodsImg> img = newInfo.getImg();
		prices = newInfo.getPrices();
		goods = newInfo.getG();
		session.setAttribute("prices", prices);
		session.setAttribute("img", img);
		session.setAttribute("goods", goods);
		return "goods";
	}

	@RequestMapping("commentGoods")
	@ResponseBody
	public Map<String, String> commentGoods(@RequestBody String data, HttpServletRequest request) {
		JSONObject jsonObj;
		Map<String, String> map = new HashMap<>();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		try {
			jsonObj = new JSONObject(data);
			int goodsId = (int) jsonObj.get("goodsId");
			String content = (String) jsonObj.get("content");
			System.out.println("\n\n\ncontent:" + content);
			System.out.println("\ngoodsId:" + goodsId);
			if (null != user) {
				int result = service.addComment(goodsId, user.getId(), content);
				if (result == -1) {
					map.put("msg", "您已经评论过了!!");
				} else if (result == 1) {
					map.put("msg", "Sensitiveword");
				} else {
					map.put("msg", "OK");
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
			map.put("msg", "error");
		}
		return map;
	}

	@RequestMapping("goodsDetail")
	public String goodsDetail(@RequestParam(value = "goodsId", required = false) int id, HttpServletRequest request,
			HttpServletResponse response) {
		service.getGoodsDetail(id);
		HttpSession session = request.getSession();
		GoodsDetail detail = service.getGoodsDetail(id);
		List<GoodsPrice> price = detail.getPrices();
		List<Integer> record = new ArrayList<>(price.size());
		for (int i = 0; i < price.size(); i++) {
			record.add(i);
		}

		List<GoodsImg> image = detail.getImage();
		List<Integer> imgrecd = new ArrayList<>(image.size());
		for (int i = 0; i < image.size(); i++) {
			imgrecd.add(i);
		}
		session.setAttribute("goods", detail.getGoods());
		session.setAttribute("image", image);
		session.setAttribute("prices", price);
		session.setAttribute("record", record);
		session.setAttribute("recd", imgrecd);
		List<Comment> comments = mapper.selectCommentByGoodsId(id);
		session.setAttribute("comments", comments);
		// browsHistory(request, response, id);
		return "showGoods";
	}

	public void browsHistory(HttpServletRequest request, HttpServletResponse response, int id) {
		System.out.println("\n\n\n-------browsHistory---------");
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {

			if (c != null && "history".equals(c.getName())) {
				String val = c.getValue();
				// System.out.println(val);
				StringBuilder builder = new StringBuilder(val);
				System.out.println("old builder:" + builder);
				builder.append(",").append(String.valueOf(id));
				System.out.println("new  builder:" + builder);
				Cookie cookie = new Cookie("history", builder.toString());
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("history", "" + id);
				response.addCookie(cookie);
			}
			/*
			 * if (c != null) { System.out.println(c.getValue()); }
			 */

		}

	}

	@RequestMapping("queryGoods")
	public String queryGoods(HttpServletRequest request,
			@RequestParam(value = "param", required = false) String param) {
		SortedGoodsInfo info = service.fuzzyQueryGoods(param);
		HttpSession session = request.getSession();
		// List list = new ArrayList(new HashSet());
		List<GoodsPrice> prices = new LinkedList<GoodsPrice>(info.getPrices());
		session.setAttribute("prices", prices);
		session.setAttribute("img", info.getImg());
		session.setAttribute("goods", info.getG());
		return "goods";
	}

	@RequestMapping("displayGoodsByPrices")
	public String displayGoodsByPrices(HttpServletRequest request) {
		SortedGoodsInfo info = service.orderByPrice();
		HttpSession session = request.getSession();
		saveInfoToSession(session, info);
		return "goods";
	}

	@RequestMapping("displayGoodsBySalesVolume")
	public String displayGoodsBySalesVolume(HttpServletRequest request) {
		SortedGoodsInfo info = service.orderBySalesVolume();
		HttpSession session = request.getSession();
		saveInfoToSession(session, info);
		return "goods";
	}

	@RequestMapping("displayGoodsByPricesDecline")
	public String displayGoodsByPricesDecline(HttpServletRequest request) {
		SortedGoodsInfo info = service.orderByPriceDecline();
		HttpSession session = request.getSession();
		saveInfoToSession(session, info);
		return "goods";
	}

	@RequestMapping("displayGoodsBySalesVolumeDecline")
	public String displayGoodsBySalesVolumeDecline(HttpServletRequest request) {
		SortedGoodsInfo info = service.orderBySalesVolumeDecline();
		HttpSession session = request.getSession();
		saveInfoToSession(session, info);
		return "goods";
	}

	private void saveInfoToSession(HttpSession session, SortedGoodsInfo info) {
		session.setAttribute("prices", info.getPrices());
		session.setAttribute("img", info.getImg());
		session.setAttribute("goods", info.getG());
	}
}
