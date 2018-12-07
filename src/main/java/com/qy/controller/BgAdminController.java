package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.qy.domain.AdminEntity;
import com.qy.service.BgAdminLoginService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/login")

public class BgAdminController {
    @Resource
    private BgAdminLoginService bgAdminLoginService;
    int i=0;
//登录
//判断用户名是否存在
    @RequestMapping("/isExist")
    @ResponseBody
    public String isExist(AdminEntity adminEntity, HttpServletRequest request){

      if (!bgAdminLoginService.isExistaName(adminEntity)){
            i=1;
          return JSON.toJSONString(i);

//判断密码是否正确
      }else if (!bgAdminLoginService.isExistaPwd(adminEntity)){
            i=2;
            return JSON.toJSONString(i);
        }
        i=3;
// 将当前用户提交到session中
    request.getSession().setAttribute("ADMIN_SESSION_KEY",adminEntity);

       return JSON.toJSONString(i);
    }

@RequestMapping("/getName")
@ResponseBody
public String getName(HttpServletRequest request){
        AdminEntity adminEntity=(AdminEntity) request.getSession().getAttribute("ADMIN_SESSION_KEY");
        return JSON.toJSONString(adminEntity) ;
}



//    -----------------------------------------------------------------------------------

@RequestMapping("/isaPwd")
@ResponseBody
public String isaPwd(String oldpwd,String newpwd,String repwd,HttpServletRequest request) {
    //判断原密码是否正确

    if (!bgAdminLoginService.isaPwd(oldpwd, request)) {
        i = 1;
        return JSON.toJSONString(i);
        //判断密码是不是新密码

    } else if (!bgAdminLoginService.isOldPwd(request, newpwd)) {
        i = 2;
        return JSON.toJSONString(i);
        //判断两次是否一致
    } else {
        Boolean b= bgAdminLoginService.isOkPwd(newpwd, repwd, request);
//    可以修改的话进行修改
//将对象传给后端


        i = 4;
        return JSON.toJSONString(i);
    }

}

//-----------------------------------------------------------------------------------------
//判断个人信息是否修改成功
@RequestMapping("/changeaMsg")
@ResponseBody
public String changeaMsg(AdminEntity adminEntity,HttpServletRequest request){

//获取修改的值
   /* System.out.println("账号"+adminEntity.getaAccount());
    System.out.println("姓名"+adminEntity.getaName());*/

    if (!bgAdminLoginService.changeaMsg(adminEntity,request)){
       // System.out.println(111);
        return JSON.toJSONString("修改失败");
    }
    //System.out.println(2222);
    return JSON.toJSONString("信息修改成功");
}
//set注入
    public void setBgAdminLoginService(BgAdminLoginService bgAdminLoginService) {
        this.bgAdminLoginService = bgAdminLoginService;
    }
}
