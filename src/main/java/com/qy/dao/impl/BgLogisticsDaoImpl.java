package com.qy.dao.impl;

import com.qy.dao.BgLogisticsDao;
import com.qy.domain.LogisticsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "bgLogisticsDao")
//物流表的实现类
public class BgLogisticsDaoImpl implements BgLogisticsDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public boolean add(LogisticsEntity log) {
        hibernateTemplate.save(log);
        return true;
    }
    //setter方法
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
