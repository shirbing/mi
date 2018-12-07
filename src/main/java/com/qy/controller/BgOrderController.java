package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.qy.domain.DetailviewEntity;
import com.qy.domain.OrdersEntity;
import com.qy.service.BgOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bgorder")
public class BgOrderController {
    @Autowired
    @Qualifier(value = "bgOrderService")
    private BgOrderService bgOrderService;
    @RequestMapping("/list")
    @ResponseBody
    public String getList(OrdersEntity order, int page){
        List<OrdersEntity>list=bgOrderService.getList(order,page);
        return JSON.toJSONString(list);
    }
    //修改付款状态
    @RequestMapping("/editsend")
    @ResponseBody
    public String editPrice(OrdersEntity order){
        if(!bgOrderService.editSend(order)){
            return  JSON.toJSONString("false");
        }
        return JSON.toJSONString("true");
    }
    //查询订单详情
    @RequestMapping("/find")
    @ResponseBody
    public String find(DetailviewEntity detail){
        List<DetailviewEntity> list=bgOrderService.list(detail);
        return JSON.toJSONString(list);
    }
    //setter方法
    public void setBgOrderService(BgOrderService bgOrderService) {
        this.bgOrderService = bgOrderService;
    }
}
