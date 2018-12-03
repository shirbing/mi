package com.qy.dao.impl;

import com.qy.dao.BgAdminLoginDao;
import com.qy.domain.AdminEntity;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Repository
public class BgAdminLoginDaoImpl implements BgAdminLoginDao {
    @Resource
    private HibernateTemplate hibernateTemplate;


//判断用户名存在
    @Override
    public boolean isExistaName(AdminEntity adminEntity) {
        Session session =hibernateTemplate.getSessionFactory().getCurrentSession();
        List<AdminEntity> list=session.createQuery("from AdminEntity").list();

        for (AdminEntity tmp:list) {

            if(adminEntity.getaName().equals(tmp.getaName())){
                return true;
            }
        }
        return false;
    }
//判断密码是否正确
    @Override
    public boolean isExistaPwd(AdminEntity adminEntity) {

        Session session =hibernateTemplate.getSessionFactory().getCurrentSession();
        List<AdminEntity> list=session.createQuery("from AdminEntity").list();

        for (AdminEntity tmp:list) {

            if(adminEntity.getaPwd().equals(tmp.getaPwd())){
                return true;
            }
        }
        return false;
    }
//    --------------------------------------------------------------------------------
//判断原密码是否正确
    @Override
    public boolean isaPwd(String oldpwd,HttpServletRequest request) {

        AdminEntity a=(AdminEntity)request.getSession().getAttribute("ADMIN_SESSION_KEY");

        if (a.getaPwd().equals(oldpwd)){

            return true;
        }
        return false;
    }
//判断新密码是不是和旧密码一样
    @Override
    public boolean isOldPwd(HttpServletRequest request,String newpwd) {
        AdminEntity a=(AdminEntity)request.getSession().getAttribute("ADMIN_SESSION_KEY");
        System.out.println(a.getaPwd());
        System.out.println(newpwd);
       if (!a.getaPwd().equals(newpwd)){
           return true;
       }
        return false;
    }


//    判断两次密码是否一样，并且将新密码保存到数据库
@Override
public boolean isOkPwd(String newpwd, String repwd, HttpServletRequest request) {
    Session session =hibernateTemplate.getSessionFactory().getCurrentSession();
    AdminEntity a=(AdminEntity)request.getSession().getAttribute("ADMIN_SESSION_KEY");
    System.out.println(newpwd+" "+repwd);
    AdminEntity adminEntity1=(AdminEntity) session.createQuery("from AdminEntity where aName=?").setParameter(0,a.getaName()).uniqueResult();
    adminEntity1.setaPwd(repwd);

    session.update(adminEntity1);
//    session.createQuery("update AdminEntity set ? where aName=?").setParameter(0,adminEntity1).setParameter(1,a.getaName());
//    (AdminEntity)request.getSession().getAttribute("ADMIN_SESSION_KEY").aPwd=newpwd;


        return false;
}

//    -------------------------------------------------------------------------------
//判断个人信息是否修改成功(姓名唯一)
    @Override
    public boolean changeaMsg(AdminEntity adminEntity,HttpServletRequest request) {
        Session session =hibernateTemplate.getSessionFactory().getCurrentSession();
        AdminEntity a=(AdminEntity)request.getSession().getAttribute("ADMIN_SESSION_KEY");
          AdminEntity adminEntity1=(AdminEntity) session.createQuery(" from AdminEntity where aName=? ").setParameter(0,a.getaName()).uniqueResult();

        adminEntity1.setaAccount(adminEntity.getaAccount());

        adminEntity1.setaName(adminEntity.getaName());
        session.update(adminEntity1);


        return true;
    }
//-------------------------------------------------------------------------------------
//set方法，调用数据库语句模板
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
