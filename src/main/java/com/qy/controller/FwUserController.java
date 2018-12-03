package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.qy.domain.UserEntity;
import com.qy.service.FwUserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/FwUser")
public class FwUserController {
    @Autowired
    @Qualifier(value = "FwUserService")
    private FwUserService fwUserService;

    public void setFwUserService(FwUserService fwUserService) {
        this.fwUserService = fwUserService;
    }
    @RequestMapping("/toLogin")
    @ResponseBody
    public  String toLogin(UserEntity userEntity, HttpServletRequest request){
        int i=0;

        if(fwUserService.userNameIsExist(userEntity)){
            if (fwUserService.toLogin(userEntity)){
                if (!fwUserService.isState(userEntity)){
                    i=1;
                    request.getSession().setAttribute("USERENTITY_SESSION_KEY",userEntity);
                    return JSON.toJSONString(i) ;
                }
                i=2;
                return JSON.toJSONString(i) ;
            }
            i=3;
            return JSON.toJSONString(i) ;
        }
        return JSON.toJSONString(i) ;
    }
    @RequestMapping("/register")
    @ResponseBody
    public  String register(UserEntity userEntity){
        int i=0;
        if(!fwUserService.userNameIsExist(userEntity)){
           if(fwUserService.saveUser(userEntity)){
               i=1;
               return JSON.toJSONString(i);
           }
        }
        return JSON.toJSONString(i) ;
    }
    @RequestMapping("/reUser")
    @ResponseBody
    public String saveGoods(UserEntity userEntity, @RequestParam("uIcon1") MultipartFile myfile, HttpServletRequest request){
        String filename=myfile.getOriginalFilename();
        userEntity.setuIcon("images/"+filename);
       /* System.out.println("存在数据库里：==images/"+filename);*/
        String path2=request.getServletContext().getRealPath("forward//images");
        /*System.out.println(path2);*/

        File destFile=new File(path2+File.separatorChar+filename);
        try {
            InputStream in =myfile.getInputStream();
            FileUtils.copyInputStreamToFile(in,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
        UserEntity userEntity1=(UserEntity) request.getSession().getAttribute("USERENTITY_SESSION_KEY");
        if(fwUserService.updateUser(userEntity,userEntity1)){
            i=1;
            return JSON.toJSONString(i);
        }
        return JSON.toJSONString(i);
    }

}
