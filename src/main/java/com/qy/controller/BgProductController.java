package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.qy.domain.ProductEntity;
import com.qy.service.BgProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bgproduct")
public class BgProductController {
    @Autowired
    @Qualifier(value = "bgProductService")
    private BgProductService bgProductService;
    @RequestMapping("/product")
    @ResponseBody
    //添加产品
    public String addProduct(ProductEntity product){
        bgProductService.addProduct(product);
        return JSON.toJSONString("true");
    }
    @RequestMapping("/list")
    @ResponseBody
    //查询产品
    public String getList(ProductEntity product, int page){
        //System.out.println(product.getpName()+" "+product.getpStyle()+" "+page);
        List<ProductEntity> list=bgProductService.getList(product,page);
        return JSON.toJSONString(list);
    }
    @RequestMapping("/edit")
    @ResponseBody
    //编辑产品
    public String editProduct(ProductEntity product){
        bgProductService.editProduct(product);
        return JSON.toJSONString("true");
    }
    //删除产品
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(ProductEntity product){
        bgProductService.delect(product);
        return JSON.toJSONString("true");
    }
    public void setBgProductService(BgProductService bgProductService) {
        this.bgProductService = bgProductService;
    }
}
