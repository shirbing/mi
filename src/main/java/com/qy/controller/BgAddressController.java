package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.qy.domain.GetgoodEntity;
import com.qy.domain.UserEntity;
import com.qy.service.BgAddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/address")
public class BgAddressController {
    @Resource
    private BgAddressService bgAddressService;


    /*增加*/
    @RequestMapping("/saveAddress")
    @ResponseBody
    public String saveAddress(GetgoodEntity getgoodEntity, HttpServletRequest request){
        UserEntity userEntity=(UserEntity) request.getSession().getAttribute("USERENTITY_SESSION_KEY");
        getgoodEntity.setuName(userEntity.getuName());
    int i=0;
    if(!bgAddressService.saveAddress(getgoodEntity)){
        i=1;
        return JSON.toJSONString(i);
    }
        i=2;
    return JSON.toJSONString(i);
    }

    /*删除*/
    @RequestMapping("/deleteAddress")
    @ResponseBody
    public String deleteAddress(GetgoodEntity getgoodEntity){
        int i=0;
        if (bgAddressService.deleteAddress(getgoodEntity)){
            i=1;
            return JSON.toJSONString(i);
        }
            i=2;
        return JSON.toJSONString(i);
    }

    /*修改*/
    @RequestMapping("/updateAddress")
    @ResponseBody
    public String updateAddress(GetgoodEntity getgoodEntity){
        int i=0;
        if (!bgAddressService.updateAddress(getgoodEntity)){
            i=1;
            return JSON.toJSONString(i);
        }
        i=2;
        return JSON.toJSONString(i);
    }

    /*列表分页*/
    @RequestMapping("/listAddress")
    @ResponseBody
    public String listAddress(int currentpage, HttpServletRequest request){
        UserEntity userEntity=(UserEntity) request.getSession().getAttribute("USERENTITY_SESSION_KEY");
//        System.out.println(userEntity.getuName()+" "+currentpage);
      List<GetgoodEntity> list=bgAddressService.listAddress(currentpage,userEntity);
        return JSON.toJSONString(list);
    }

    /*收货地址*/
    @RequestMapping("/changeState")
    @ResponseBody
    public String changeStatus(GetgoodEntity getgoodEntity){
        int i=0;
        if(bgAddressService.defaultAddress(getgoodEntity)){
            i=1;
            return JSON.toJSONString(i);
        }
            i=2;
        return JSON.toJSONString(i);
    }



//set--------------------------------------------------------------------------
    public void setBgAddressService(BgAddressService bgAddressService) {
        this.bgAddressService = bgAddressService;
    }
}
