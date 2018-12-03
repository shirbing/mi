package com.qy.controller;


import com.alibaba.fastjson.JSON;
import com.qy.domain.AdminEntity;
import com.qy.service.BgAdminLoginService;
import com.qy.service.BgAdminMgeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/manage")
public class BgAdminMgeController {
    @Resource
    private BgAdminLoginService bgAdminLoginService;
    @Resource
    private BgAdminMgeService bgAdminMgeService;
    int i=0;

//添加管理员
    @RequestMapping("/addadmin")
    @ResponseBody
    public String addadmin(AdminEntity adminEntity){

        //判断用户名是否存在
       if (bgAdminLoginService.isExistaName(adminEntity)){
            i=1;
            return JSON.toJSONString(i);
        }
        System.out.println("test");
         //添加进数据库
        if (!bgAdminMgeService.BgAdminAdd(adminEntity)){
            i=2;
            return JSON.toJSONString(i);
        }
        i=3;
        return JSON.toJSONString(i);
    }
//    列表
    @RequestMapping("/listadmin")
    @ResponseBody
    public String listadmin(int currentpage){

       List<AdminEntity>list =bgAdminMgeService.BgAdminList(currentpage);
        //System.out.println(JSON.toJSON(list));
        return JSON.toJSONString(list);
    }

// 删除管理员
    @RequestMapping("/deleteadmin")
    @ResponseBody
    public String deleteadmin(AdminEntity adminEntity){
        if (bgAdminMgeService.BgAdmindelete(adminEntity)){
            i=1;
            return JSON.toJSONString(i);
        }
        i=2;
        return JSON.toJSONString(i);
    }
//set方法
    public void setBgAdminMgeService(BgAdminMgeService bgAdminMgeService) {
        this.bgAdminMgeService = bgAdminMgeService;
    }
}
