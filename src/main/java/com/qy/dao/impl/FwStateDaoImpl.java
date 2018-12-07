package com.qy.dao.impl;

import com.qy.dao.FwStateDao;
import com.qy.domain.DetailviewEntity;
import com.qy.domain.UserEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "fwStateDao")
public class FwStateDaoImpl implements FwStateDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    //未付款
    @Override
    public List<DetailviewEntity> list(int page, UserEntity userEntity) {
       Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
       List<DetailviewEntity> list=session.createQuery("from DetailviewEntity where oPaystate=? and uName=?").setParameter(0,"未支付").setParameter(1,userEntity.getuName()).setFirstResult((page-1)*3).setMaxResults(3).list();
        return list;
    }
    //未收货
    @Override
    public List<DetailviewEntity> find(int page, UserEntity userEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        List<DetailviewEntity> list=session.createQuery("from DetailviewEntity where oOk=? and uName=?").setParameter(0,"未收货").setParameter(1,userEntity.getuName()).setFirstResult((page-1)*3).setMaxResults(3).list();
        return list;
    }
    //交易是否成功
    @Override
    public List<DetailviewEntity> getList(int page,UserEntity userEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        List<DetailviewEntity> list=session.createQuery("from DetailviewEntity where oIsevaluate=? and uName=?").setParameter(0,"未评价").setParameter(1,userEntity.getuName()).setFirstResult((page-1)*3).setMaxResults(3).list();
        return list;
    }
    //setter方法
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
