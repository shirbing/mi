package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.qy.domain.DetailviewEntity;
import com.qy.domain.OrdersEntity;
import com.qy.domain.UserEntity;
import com.qy.service.FwOrderListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/order")
public class FwOrderListController {
    @Resource
    private FwOrderListService fwOrderListService;
    int i=0;


//保存
@RequestMapping("/saveOrder")
@ResponseBody
public String saveOrder(OrdersEntity ordersEntity, HttpServletRequest request){
    UserEntity userEntity=(UserEntity)request.getSession().getAttribute("USERENTITY_SESSION_KEY");
    ordersEntity.setuName(userEntity.getuName());
   if(fwOrderListService.saveOrder(ordersEntity)){
//       失败
      i=1;
      return JSON.toJSONString(i);
   }
//      成功
   i=2;
    return JSON.toJSONString(i);
}


//列表
@RequestMapping("/listOrder")
@ResponseBody
public String listOrder(OrdersEntity ordersEntity,int currentpage,HttpServletRequest request){
    UserEntity userEntity=(UserEntity) request.getSession().getAttribute("USERENTITY_SESSION_KEY");
    ordersEntity.setuName(userEntity.getuName());
    List<DetailviewEntity>list=fwOrderListService.listOrder(ordersEntity,currentpage);

    return JSON.toJSONString(list);
}
//删除
@RequestMapping("/deleteOrder")
@ResponseBody
public String deleteOrder(OrdersEntity ordersEntity){
    if (fwOrderListService.deleteOrder(ordersEntity)){
        i=1;
        return JSON.toJSONString(i);
    }
    i=2;
    return JSON.toJSONString(i);
}


//付款
@RequestMapping("/paystateOrder")
@ResponseBody
public String paystateOrder(OrdersEntity ordersEntity){
    if (fwOrderListService.paystateOrder(ordersEntity)){
        i=1;
        return JSON.toJSONString(i);
    }
    i=2;
    return  JSON.toJSONString(i);
}


//收货
@RequestMapping("/okOrder")
@ResponseBody
public  String okOrder(OrdersEntity ordersEntity){
    if(fwOrderListService.okOrder(ordersEntity)){
        i=1;
        return JSON.toJSONString(i);

    }
    i=2;
    return JSON.toJSONString(i);
}


//评价
@RequestMapping("/isevaluateOrder")
@ResponseBody
public String isevaluateOrder(OrdersEntity ordersEntity){
    if (fwOrderListService.isevaluateOrder(ordersEntity)){
        i=1;
        return JSON.toJSONString(i);
    }
    i=2;
    return JSON.toJSONString(i);
}







//    set
    public void setFwOrderListService(FwOrderListService fwOrderListService) {
        this.fwOrderListService = fwOrderListService;
    }
}
