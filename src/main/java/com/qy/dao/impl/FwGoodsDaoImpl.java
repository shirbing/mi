package com.qy.dao.impl;

import com.qy.dao.FwGoodsDao;
import com.qy.domain.GoodsEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "FwGoodsDao")

public class FwGoodsDaoImpl implements FwGoodsDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<GoodsEntity> findGoodsRecommend() {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        List<GoodsEntity> goodsEntityList=session.createQuery("from GoodsEntity where gRecommend=?").setParameter(0,"是").list();
        return goodsEntityList;
    }

    @Override
    public GoodsEntity findOne(GoodsEntity goodsEntity) {
        return hibernateTemplate.findByExample(goodsEntity).get(0);
    }
}
