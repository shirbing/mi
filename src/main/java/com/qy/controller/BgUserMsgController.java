package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.qy.domain.UserEntity;
import com.qy.service.BgUserMsgService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class BgUserMsgController {
    @Autowired
    @Qualifier(value = "bgUserMsgService")
    private BgUserMsgService bgUserMsgService;

    @RequestMapping("/management")
    @ResponseBody
    //用户管理
    public String userManagement(UserEntity user, int currentpage, String starttime, String endtime)throws ParseException  {
        if(endtime==null||starttime==null){
            starttime =null;
            endtime = null;
        }
        List<UserEntity> list=bgUserMsgService.getList(user,currentpage,starttime,endtime);
        System.out.println(list);
        return JSON.toJSONString(list);
    }
    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(UserEntity userEntity){

        int i=0;
        if (!bgUserMsgService.deleteUser(userEntity)){
            i=1;
            return JSON.toJSONString(i);
        }
        i=2;
        return JSON.toJSONString(i);
    }
    //setter方法
    public void setBgUserMsgService(BgUserMsgService bgUserMsgService) {
        this.bgUserMsgService = bgUserMsgService;
    }

}
