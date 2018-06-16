package com.alibaba.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.entity.GoodsImg;
import com.alibaba.entity.GoodsInOrder;
import com.alibaba.entity.GoodsPrice;
import com.alibaba.entity.Order;
import com.alibaba.entity.User;
import com.alibaba.service.impl.ShowOrderServiceImpl;

@Controller
@RequestMapping("showOrder")
public class ShowOrderController {

	@Autowired
	private ShowOrderServiceImpl service;

	@RequestMapping("getOrderInfo")
	public String getOrderInfo(HttpServletRequest request) {
		//根据用户名获取用户ID
		Integer userId = service.getUserIdByUserName(((User)request.getSession().getAttribute("user")).getUserName());
		
		
		//获取该用户的所有订单信息(订单号，交易时间，姓名，数量)
		List<Order> orderInfo = service.getOrderInfo(userId);
		
		//存放订单号的集合,由此来得知订单数,便于显示订单信息
		List<Integer> orderIdList = new ArrayList<Integer>();
		//存放订单中的商品的信息的集合(获取type)
		List<GoodsInOrder> gioList = new ArrayList<GoodsInOrder>();
		
		//存放商品ID的集合
		List<Integer>  goodsIdList = new ArrayList<Integer>();
		//存放商品型号的集合
		List<String>  typeList = new ArrayList<String>();
		
		if(orderInfo != null && orderInfo.size() > 0){
			
			for(Order order : orderInfo){
				
				orderIdList.add(order.getOrderId());
				gioList.add(service.getGoodsInOrderInfoByOrderId(order.getOrderId()));
			}
			
		}
		
		if(gioList != null && gioList.size() > 0){
			
			for(GoodsInOrder gio : gioList){
				
				goodsIdList.add(gio.getGoodsId());
				typeList.add(gio.getType());
			}
			
		}
		
		List<GoodsPrice> priceList = new ArrayList<GoodsPrice>();
		List<String> goodsNameList = new ArrayList<String>();
		List<List<GoodsImg>> imgList = new ArrayList<List<GoodsImg>>();
		List<String> commentList = new ArrayList<String>();
		if(goodsIdList != null && goodsIdList.size() > 0){
			
			for(Integer goodsId : goodsIdList){
				commentList.add(service.getComment(userId, goodsId));
				goodsNameList.add(service.getGoodsNameByGoodsId(goodsId));
				imgList.add(service.getGoodsImg(goodsId));
				for(String type : typeList){
					priceList.add(service.getPriceByIdAndType(goodsId, type));
				}
			}
			
		}
		
		
		
		request.getSession().setAttribute("gioList", gioList);
		request.getSession().setAttribute("orderInfo", orderInfo);
		request.getSession().setAttribute("imgList", imgList);
		request.getSession().setAttribute("priceList", priceList);
		request.getSession().setAttribute("goodsNameList", goodsNameList);
		request.getSession().setAttribute("commentList", commentList);
		request.getSession().setAttribute("num", new Integer(orderInfo.size()));
		return "orderInfo";
	}

}
