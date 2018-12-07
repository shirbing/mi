package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.qy.domain.DetailviewEntity;
import com.qy.domain.UserEntity;
import com.qy.service.FwStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/state")
public class FwStateController {
    @Autowired
    @Qualifier(value = "fwStateService")
    private FwStateService fwStateService;
    @RequestMapping("/paystate")
    @ResponseBody
    //未付款
    public String list(int currentpage, HttpServletRequest request){
        System.out.println(currentpage);
        UserEntity userEntity=(UserEntity) request.getSession().getAttribute("USERENTITY_SESSION_KEY");
        List<DetailviewEntity> list=fwStateService.list(currentpage,userEntity);
       return JSON.toJSONString(list);
    }
    @RequestMapping("/sendstate")
    @ResponseBody
    public String find(int currentpage,HttpServletRequest request){
        UserEntity userEntity=(UserEntity) request.getSession().getAttribute("USERENTITY_SESSION_KEY");
        List<DetailviewEntity>list=fwStateService.find(currentpage,userEntity);
        return JSON.toJSONString(list);
    }
    @RequestMapping("/isevaluate")
    @ResponseBody
    public String getList(int currentpage,HttpServletRequest request){
        UserEntity userEntity=(UserEntity) request.getSession().getAttribute("USERENTITY_SESSION_KEY");
        List<DetailviewEntity>list=fwStateService.getList(currentpage,userEntity);
        return JSON.toJSONString(list);
    }
    public void setFwStateService(FwStateService fwStateService) {
        this.fwStateService = fwStateService;
    }
}
