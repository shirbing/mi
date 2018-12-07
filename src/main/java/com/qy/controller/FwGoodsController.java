package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.qy.domain.GoodsEntity;
import com.qy.service.FwGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/FwGoods")
public class FwGoodsController {
    @Autowired
    @Qualifier(value = "FwGoodsService")
    private FwGoodsService fwGoodsService;
    public void setFwGoodsService(FwGoodsService fwGoodsService) {
        this.fwGoodsService = fwGoodsService;
    }
    @RequestMapping("/recommend")
    @ResponseBody
    public String findGoodsRecommend(){
        List<GoodsEntity> goodsEntityList= fwGoodsService.findGoodsRecommend();
        return JSON.toJSONString(goodsEntityList);
    }
    @RequestMapping("/findOne")
    @ResponseBody
    public String findOne(GoodsEntity goodsEntity){
        GoodsEntity goodsEntity1= fwGoodsService.findOne(goodsEntity);
        return JSON.toJSONString(goodsEntity1);
    }

}
