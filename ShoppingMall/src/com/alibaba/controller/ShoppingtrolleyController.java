package com.alibaba.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.entity.TrolleyInfo;
import com.alibaba.entity.User;
import com.alibaba.service.impl.ShoppingtrolleyServiceImpl;

@Controller
@RequestMapping("Shoppingtrolley")
public class ShoppingtrolleyController {

	@Autowired
	private ShoppingtrolleyServiceImpl service;

	@RequestMapping("addGoods")
	public String addGoods(HttpServletRequest request, @RequestParam("price") double price,
			@RequestParam("type") String type, @RequestParam("color") String color, @RequestParam("number") int number,
			@RequestParam("rear") String rear, @RequestParam("front") String front,
			@RequestParam("capacity") String capacity, @RequestParam("goodsId") int goodsId) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			Integer shoppingtrolleyId = (Integer) session.getAttribute("shoppingtrolleyId");
			// System.out.print("\n\n\n加购物车ing... userid:" + user);
			// System.out.print("\n\n\n加购物车ing... 购物车id:" + shoppingtrolleyId + "\n\n");
			service.addGoods(price, goodsId, number, shoppingtrolleyId, rear, front, capacity, type);
		}
		// int shoppingtrolleyId = 0;
		// @SuppressWarnings("unchecked")
		// List<goodsInShoppingtrolley> trolley = (List<goodsInShoppingtrolley>) session
		// .getAttribute("shoppingtrolley");
		// if (trolley == null) {
		// trolley = new LinkedList<goodsInShoppingtrolley>();
		//
		// goodsInShoppingtrolley goods = new goodsInShoppingtrolley(shoppingtrolleyId,
		// goodsId, type, capacity,
		// front, rear, number, number * price);
		// trolley.add(goods);
		//
		// } else {
		// goodsInShoppingtrolley goods = new goodsInShoppingtrolley(shoppingtrolleyId,
		// goodsId, type, capacity,
		// front, rear, number, number * price);
		// trolley.add(goods);
		// }
		// session.setAttribute("shoppingtrolley", trolley);

		return "";
	}

	@RequestMapping("queryTrolleyInfo")
	public String queryTrolleyInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int trolleyId = 0;
		if (user != null) {
			trolleyId = (Integer) session.getAttribute("shoppingtrolleyId");
			TrolleyInfo info = service.queryTrolley(trolleyId);
			session.setAttribute("prices", info.getPrices());
			session.setAttribute("names", info.getNames());
			session.setAttribute("goodsInTrolley", info.getTrolley());
			session.setAttribute("totalPrice", info.getTotalPrice());
			session.setAttribute("totalQuantity", info.getTotalQuantity());
			session.setAttribute("quantities", info.getQuantities());
			return "QueryTrolley";
		} /*
			 * else { return "login"; }
			 */
		return "";

	}

	@RequestMapping("deleteGoods")
	@ResponseBody
	public Map<String, String> deleteGoods(@RequestBody String data) {
		JSONObject jsonObj;
		Map<String, String> map = new HashMap<>();
		try {
			jsonObj = new JSONObject(data);
			int goodsId = (int) jsonObj.get("goodsId");
			int trolleyId = (int) jsonObj.get("trolleyId");
			System.out.println("\n\n\ntrolleyId:" + trolleyId);
			System.out.println("\n\n\ngoodsId:" + goodsId);
			service.deleteGoods(goodsId, trolleyId);
			map.put("msg", "OK");
		} catch (JSONException e) {
			e.printStackTrace();
			map.put("msg", "error");
		}
		return map;
	}

	@RequestMapping("updateQuantity")
	@ResponseBody
	public Map<String, String> updateQuantity(@RequestBody String data) {
		JSONObject jsonObj;
		Map<String, String> map = new HashMap<>();
		try {
			jsonObj = new JSONObject(data);
			int goodsId = (int) jsonObj.get("goodsId");
			int number = (int) jsonObj.get("number");
			int trolleyId = (int) jsonObj.get("trolleyId");
			int price = (int) jsonObj.get("price");

//			System.out.println("\n\n\ntrolleyId:" + trolleyId);
//			System.out.println("\n\n\ngoodsId:" + goodsId);
//			System.out.println("\n\n\nnumber:" + number);
//			System.out.println("\n\n\nprice:" + price);
//			System.out.println("\n\n\ngoodsId:" + trolleyId);

			service.modifyGoodsQuantity(number, price * number, trolleyId, goodsId);
			map.put("msg", "OK");
		} catch (JSONException e) {
			e.printStackTrace();
			map.put("msg", "error");
		}
		return map;
	}

	// @RequestMapping("deleteGoods")
	// @ResponseBody
	// public Map<String, String> deleteGoods(@RequestBody String data,
	// HttpServletRequest request) {
	// HttpSession session = request.getSession();
	// JSONObject jsonObj;
	// Map<String, String> map = new HashMap<>();
	// try {
	// jsonObj = new JSONObject(data);
	// int goodsId = Integer.valueOf(jsonObj.get("goodsId").toString());
	// int shoppingtrolleyId = (Integer) session.getAttribute("shoppingtrolleyId");
	// service.deleteGoods(goodsId, shoppingtrolleyId);
	// map.put("msg", "OK");
	// } catch (JSONException e) {
	// e.printStackTrace();
	// map.put("msg", "error");
	// }
	// return map;
	// }

}
