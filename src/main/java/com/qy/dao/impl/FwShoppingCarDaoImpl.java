package com.qy.dao.impl;

import com.qy.dao.FwShoppingCarDao;
import com.qy.domain.ShopcarEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "fwShoppingCarDao")
public class FwShoppingCarDaoImpl implements FwShoppingCarDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    //添加购物车
    public boolean addShoppingCar(ShopcarEntity shop) {
        hibernateTemplate.save(shop);
        return true;
    }

    @Override
    //删除购物车
    public boolean delete(ShopcarEntity shop) {
      Session session= hibernateTemplate.getSessionFactory().getCurrentSession();
      session.createQuery("delete ShopcarEntity where sId=?").setParameter(0,shop.getsId()).executeUpdate();
      return true;
    }

    @Override
    //查询购物车
    public List<ShopcarEntity> getList(ShopcarEntity shop) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        List<ShopcarEntity> list=session.createQuery("from ShopcarEntity where sName=?").setParameter(0,shop.getsName()).list();
        return list;
    }

    @Override
    //更新购物车
    public boolean update(ShopcarEntity shop) {
        //int num=shop.getsNum()+1;
        double sprice=(shop.getsNum()+1)*shop.getsPrice();
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        session.createQuery("update ShopcarEntity set sNum=?,sSumprice=? where sId=?").setParameter(0,shop.getsNum()+1).setParameter(1,sprice).setParameter(2,shop.getsId()).executeUpdate();
        return true;
    }

    @Override
    //分页查询
    public List<ShopcarEntity> list(ShopcarEntity shopcarEntity) {
        Session session= hibernateTemplate.getSessionFactory().getCurrentSession();
        List<ShopcarEntity> list=session.createQuery("from ShopcarEntity where uName=?").setParameter(0,shopcarEntity.getuName()).list();
        return list;
    }
    //setter方法
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
