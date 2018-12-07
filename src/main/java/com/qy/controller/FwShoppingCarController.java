package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.qy.domain.ShopcarEntity;
import com.qy.domain.UserEntity;
import com.qy.service.FwShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class FwShoppingCarController {
    @Autowired
    @Qualifier(value = "fwShoppingCarService")
    private FwShoppingCarService fwShoppingCarService;
    @RequestMapping("/car")
    @ResponseBody
    public String addShopCar(ShopcarEntity shop, HttpServletRequest request){
        UserEntity userEntity=(UserEntity) request.getSession().getAttribute("USERENTITY_SESSION_KEY");
        shop.setuName(userEntity.getuName());
        if(fwShoppingCarService.getList(shop).size()==0){
             if(!fwShoppingCarService.addShoppingCar(shop)){
                 return JSON.toJSONString("false");
             }
             return JSON.toJSONString("true");
         }else {
             if(!fwShoppingCarService.update(shop)){
                 return JSON.toJSONString("false");
             }
             return JSON.toJSONString("true");
         }
    }
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(ShopcarEntity shop){
        if(!fwShoppingCarService.delete(shop)){
            return JSON.toJSONString("false");
        }
        return JSON.toJSONString("true");
    }
    @RequestMapping("/search")
    @ResponseBody
    //购物车列表分页查询商品
    public String list(ShopcarEntity shopcarEntity, HttpServletRequest request){
       UserEntity userEntity=(UserEntity) request.getSession().getAttribute("USERENTITY_SESSION_KEY");
       shopcarEntity.setuName(userEntity.getuName());
       List<ShopcarEntity> list=fwShoppingCarService.list(shopcarEntity);
       return JSON.toJSONString(list);
    }
    public void setFwShoppingCarService(FwShoppingCarService fwShoppingCarService) {
        this.fwShoppingCarService = fwShoppingCarService;
    }
}
