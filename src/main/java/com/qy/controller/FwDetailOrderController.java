package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.qy.domain.DetailviewEntity;
import com.qy.service.FwDetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//订单详情表，前端（forward）
@Controller
@RequestMapping("/fworder")
public class FwDetailOrderController {
    @Autowired
    @Qualifier(value = "fwDetailOrderService")
    private FwDetailOrderService fwDetailOrderService;
    @RequestMapping("/detail")
    @ResponseBody
    public String getList(DetailviewEntity detail){
//        System.out.println(detail.getoId());
       List<DetailviewEntity>list=fwDetailOrderService.getList(detail);
       return JSON.toJSONString(list);
    }
}
