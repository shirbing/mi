package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.qy.domain.LogisticsEntity;
import com.qy.service.BgLogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//物流
@Controller
@RequestMapping("/logistics")
public class BgLogisticsController {
     @Autowired
     @Qualifier(value = "bgLogisticsService")
     private BgLogisticsService bgLogisticsService;
     @RequestMapping("/add")
     @ResponseBody
     public String add(LogisticsEntity log){
         if (!bgLogisticsService.add(log)){
             return JSON.toJSONString("false");
         }
         return JSON.toJSONString("true");
     }
}
