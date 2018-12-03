package com.qy.dao;

import com.qy.domain.AdminEntity;

import javax.servlet.http.HttpServletRequest;


public interface BgAdminLoginDao {
//    判断用户名和密码
    public boolean isExistaName(AdminEntity adminEntity);
    public boolean isExistaPwd(AdminEntity adminEntity);
//    修改密码
    public boolean isaPwd(String oldpwd,HttpServletRequest request);
    public boolean isOldPwd(HttpServletRequest request,String newpwd);
    public boolean isOkPwd(String newpwd,String repwd,HttpServletRequest request);
    //    修改管理员个人信息
    public boolean changeaMsg(AdminEntity adminEntity,HttpServletRequest request);

}
