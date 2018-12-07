package com.qy.dao;

import com.qy.domain.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface FwOrderListDao {
    //保存订单
    public boolean saveOrder(OrdersEntity ordersEntity);

    //订单列表
    public List<DetailviewEntity> listOrder(OrdersEntity ordersEntity, int currentpage);

    //删除订单
    public boolean deleteOrder(OrdersEntity ordersEntity);

    //未支付->已支付
    public boolean paystateOrder(OrdersEntity ordersEntity);
//未发货->已发货(后端来写)

    //未收货->已收货
    public boolean okOrder(OrdersEntity ordersEntity);

    //未评价->已评价
    public boolean isevaluateOrder(OrdersEntity ordersEntity);

    //购物车
    public List<ShopcarEntity> listshopcar(OrdersEntity ordersEntity);
//    收货地址
    public GetgoodEntity address(OrdersEntity ordersEntity);
}