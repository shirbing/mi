package com.qy.dao.impl;

import com.qy.dao.FwDetailOrderDao;
import com.qy.domain.DetailviewEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "fwDetailOrderDao")
public class FwDetailOrderDaoImpl implements FwDetailOrderDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    //查询订单详情表(forward端)
    public List<DetailviewEntity> getList(DetailviewEntity detail) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        List<DetailviewEntity> list=session.createQuery("from DetailviewEntity where oId=?").setParameter(0,detail.getoId()).list();
        return list;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
