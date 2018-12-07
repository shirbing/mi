package com.qy.dao.impl;

import com.qy.dao.FwUserDao;
import com.qy.domain.UserEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "FwUserDao")
public class FwUserDaoImpl implements FwUserDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public boolean toLogin(UserEntity userEntity) {
       if (hibernateTemplate.findByExample(userEntity).size()==1){
           return true;
       }
        return false;
    }

    @Override
    public boolean userNameIsExist(UserEntity userEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        if (session.createQuery("from UserEntity where uName=?").setParameter(0,userEntity.getuName()).uniqueResult()!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean saveUser(UserEntity userEntity) {
        hibernateTemplate.save(userEntity);
        return true;
    }

    @Override
    public boolean isState(UserEntity userEntity) {
        if(hibernateTemplate.findByExample(userEntity).get(0).getuState().equals("禁用")){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(UserEntity userEntity,UserEntity userEntity1) {
        UserEntity userEntity2=hibernateTemplate.findByExample(userEntity1).get(0);
        userEntity2.setuIcon(userEntity.getuIcon());
        userEntity2.setuName(userEntity.getuName());
        userEntity2.setuPhone(userEntity.getuPhone());
        userEntity2.setuPwd(userEntity.getuPwd());
        hibernateTemplate.update(userEntity2);
        return true;
    }

    @Override
    public UserEntity personInfo(UserEntity userEntity) {
        return hibernateTemplate.findByExample(userEntity).get(0);
    }
}
