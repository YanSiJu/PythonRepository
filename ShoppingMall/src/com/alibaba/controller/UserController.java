package com.alibaba.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.alibaba.entity.Goods;
import com.alibaba.entity.GoodsImg;
import com.alibaba.entity.GoodsInfo;
import com.alibaba.entity.GoodsPrice;
import com.alibaba.entity.ShoppingTrolley;
import com.alibaba.entity.SortedGoodsInfo;
import com.alibaba.entity.User;
import com.alibaba.mapper.ShoppingTrolleyMapper;
import com.alibaba.service.impl.GoodsServiceImpl;
import com.alibaba.service.impl.UserServiceImpl;

@Controller
@RequestMapping("User")
public class UserController {

	@Autowired
	private UserServiceImpl service;

	@Autowired
	private GoodsServiceImpl goodsService;

	@Autowired
	private ShoppingTrolleyMapper trolleyMapper;

	@RequestMapping("register")
	public String register(@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "tel", required = false) String tel,
			@RequestParam(value = "name", required = false) String name, HttpServletRequest request) {
		int id = 0;
		User user = new User(name, address, userName, password, tel, id);
		service.register(user);
		request.setAttribute("userName", userName);
		return "registerSuccess";
	}

	@RequestMapping("regist")
	public String register() {
		// return "sendCode";
		return "register";
	}

	@RequestMapping("loginSkip")
	public String login() {
		return "login";
	}

	@RequestMapping("sendCode")
	@ResponseBody
	public Map<String, String> sendValidateCode(@RequestBody String mobile) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("code", "code");

		System.out.println(result);
		return result;
	}

	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "goods";
	}

	@RequestMapping("validateUserName")
	@ResponseBody
	public Map<String, String> ifUserNameDuplicate(@RequestBody String name) {
		Map<String, String> result = new HashMap<String, String>();
		try {
			JSONObject jsonobj = new JSONObject(name);
			System.out.println(jsonobj.get("name").toString());
			if (service.validateUserName(jsonobj.get("name").toString())) {
				result.put("msg", "该用户名已被注册");
			} else {
				result.put("msg", "OK");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		System.out.println("ifUserNameDuplicate\n name---->" + name + "\nresult:" + result);
		return result;
	}

	@RequestMapping("login")
	public String login(@RequestParam(value = "userName", required = false) String name,
			@RequestParam(value = "password", required = false) String pwd, HttpServletRequest request) {

		User user = service.login(name, pwd);
		if (user != null) {
			HttpSession session = request.getSession();
			// 根据userId查询出购物车
			List<ShoppingTrolley> trolley = trolleyMapper.queryShoppingTrolley(user.getId());

			// System.out.println("\n\n\n----->查询出的购物车!!" + trolley + "\n\n\n");
			if (trolley != null && trolley.size() > 0) {
				// 将购物车id保存在session里
				session.setAttribute("shoppingtrolleyId", trolley.get(0).getId());
				// System.out.print("\n\n\nLogining... 购物车id:" +
				// session.getAttribute("shoppingtrolleyId")+"\n\n");
			}
			// 保存用户信息
			session.setAttribute("user", user);
			GoodsInfo info = goodsService.displayGoods();
			List<GoodsPrice> prices = new LinkedList<GoodsPrice>(info.getPrices());
			Set<GoodsImg> image = info.getImg();
			List<Goods> goods = info.getGoods();

			SortedGoodsInfo newInfo = goodsService.moveElementsToNewCollection(goods, image, prices);
			List<GoodsImg> img = newInfo.getImg();
			prices = newInfo.getPrices();
			goods = newInfo.getG();
			// PrintInfo(goods, img, prices);

			session.setAttribute("prices", prices);
			session.setAttribute("img", img);
			session.setAttribute("goods", goods);

			// System.out.println("----->登录成功!!" + trolley.get(0).getId() + "\n\n\n");
			return "goods";
		}
		request.setAttribute("errorMsg", "帐号或密码错误，请重新输入");
		request.setAttribute("userName", name);
		request.setAttribute("pwd", pwd);
		return "login";
		/* return "forward:/index.jsp"; */
	}

	public static void PrintInfo(List<Goods> goods, List<GoodsImg> img, List<GoodsPrice> prcs) {
		System.out.println(" \n \n\n\n---------------PrintInfo  begin-------------------------");

		System.out.println("\ngoods:");
		for (Goods g : goods) {
			System.out.println(g);
		}

		System.out.println("\n\nImg:");
		for (GoodsImg i : img) {
			System.out.println(i);
		}

		System.out.println("\n\nprice:");
		for (GoodsPrice p : prcs) {
			System.out.println(p);
		}
		System.out.println("--------------PrintInfo  end-------------------------\n\n\n");
	}

}
