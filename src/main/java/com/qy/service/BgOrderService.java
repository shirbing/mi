package com.qy.service;

import com.qy.domain.DetailviewEntity;
import com.qy.domain.OrdersEntity;

import java.util.List;

public interface BgOrderService {
    //查询订单
    public List<OrdersEntity> getList(OrdersEntity order, int page);
    //修改发货状态
    public  boolean editSend(OrdersEntity order);
    //查询订单详情表
    public  List<DetailviewEntity> list(DetailviewEntity detail);
}
