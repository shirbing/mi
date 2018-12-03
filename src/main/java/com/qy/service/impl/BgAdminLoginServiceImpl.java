package com.qy.service.impl;

import com.qy.dao.BgAdminLoginDao;
import com.qy.domain.AdminEntity;
import com.qy.service.BgAdminLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class BgAdminLoginServiceImpl implements BgAdminLoginService {


    @Resource
private BgAdminLoginDao bgAdminLoginDao;

//判断用户名是否存在
    @Override
    public boolean isExistaName(AdminEntity adminEntity) {
        return bgAdminLoginDao.isExistaName(adminEntity);
    }
//判断密码是否正确
    @Override
    public boolean isExistaPwd(AdminEntity adminEntity) {
        return bgAdminLoginDao.isExistaPwd(adminEntity);
    }
//判断原密码是否正确
    @Override
    public boolean isaPwd(String oldpwd,HttpServletRequest request) {
        return bgAdminLoginDao.isaPwd(oldpwd,request);
    }
//判断新密码是不是和老密码一致
    @Override
    public boolean isOldPwd(HttpServletRequest request,String newpwd) {
        return bgAdminLoginDao.isOldPwd(request,newpwd);
    }
//判断两次是否一样，并保存在数据库
    @Override
    public boolean isOkPwd(String newpwd, String repwd, HttpServletRequest request) {
        return bgAdminLoginDao.isOkPwd(newpwd,repwd,request);
    }

    //改变个人的信息
    @Override
    public boolean changeaMsg(AdminEntity adminEntity,HttpServletRequest request) {
        return bgAdminLoginDao.changeaMsg(adminEntity,request);
    }



//    set方法dao层对象
    public void setBgAdminLoginDao(BgAdminLoginDao bgAdminLoginDao) {
        this.bgAdminLoginDao = bgAdminLoginDao;
    }
}
