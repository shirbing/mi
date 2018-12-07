package com.qy.dao.impl;

import com.qy.dao.FwOrderListDao;
import com.qy.domain.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Repository
public class FwOrderListDaoImpl implements FwOrderListDao {
    @Resource
    private HibernateTemplate hibernateTemplate;
//保存
    @Override
    public boolean saveOrder(OrdersEntity ordersEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
//       Transaction t=session.getTransaction().begin();
        session.save(ordersEntity);
        /*这两个方法时将session中的数据推进数据库，然后将这个对象给清掉*/
        session.flush();
        session.clear();
        return false;
    }
//列表
    @Override
    public List<DetailviewEntity> listOrder(OrdersEntity ordersEntity, int currentpage) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        List<DetailviewEntity>list=session.createQuery("from DetailviewEntity where uName=?").setParameter(0,ordersEntity.getuName()).setFirstResult((currentpage-1)*5).setMaxResults(5).list();
        return list;
    }
//删除
    @Override
    public boolean deleteOrder(OrdersEntity ordersEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
            session.delete(ordersEntity);
            OrdersEntity ordersEntity1=(OrdersEntity) session.createQuery("from OrdersEntity where oId=?").setParameter(0,ordersEntity.getoId()).uniqueResult();
            if (ordersEntity1==null){
                return true;
            }

        return false;
    }
//是否付款
    @Override
    public boolean paystateOrder(OrdersEntity ordersEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        OrdersEntity ordersEntity1=(OrdersEntity) session.createQuery("from OrdersEntity where oId=?").setParameter(0,ordersEntity.getoId()).uniqueResult();
//        if (ordersEntity1.getoPaystate().equals("未支付")){
            if (ordersEntity1.getoPaystate().equals("未支付")){
            ordersEntity1.setoPaystate("已支付");
            session.save(ordersEntity1);
            return true;
        }
        return false;
    }
//是否收货成功
    @Override
    public boolean okOrder(OrdersEntity ordersEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        OrdersEntity ordersEntity1=(OrdersEntity) session.createQuery("from OrdersEntity where oId=?").setParameter(0,ordersEntity.getoId()).uniqueResult();
         if ("已发货".equals(ordersEntity1.getoSendstate())&ordersEntity1.getoOk().equals("未收货")){
            ordersEntity1.setoOk("已收货");
            session.save(ordersEntity1);
            return true;
        }
        return false;
    }
//是否评价
    @Override
    public boolean isevaluateOrder(OrdersEntity ordersEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        OrdersEntity ordersEntity1=(OrdersEntity) session.createQuery("from OrdersEntity where oId=?").setParameter(0,ordersEntity.getoId()).uniqueResult();
//
        if ("已收货".equals(ordersEntity1.getoOk())&ordersEntity1.getoIsevaluate().equals("未评价")){
            ordersEntity1.setoIsevaluate("已评价");
            session.save(ordersEntity1);
            return true;
        }
        return false;
    }
//...................购物车。。。。。
    @Override
    public List<ShopcarEntity> listshopcar(OrdersEntity ordersEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        List<ShopcarEntity>list=session.createQuery("from ShopcarEntity where uName=?").setParameter(0,ordersEntity.getuName()).list();
        return list;
    }
//收货地址
    @Override
    public GetgoodEntity address(OrdersEntity ordersEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        GetgoodEntity getgoodEntity=(GetgoodEntity) session.createQuery("from GetgoodEntity where uName=? and ggState=?").setParameter(0,ordersEntity.getuName()).setParameter(1,"是").uniqueResult();
        return getgoodEntity;
    }


    //    set
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }



}
