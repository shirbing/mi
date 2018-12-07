package com.qy.dao.impl;

import com.qy.dao.BgOrderDao;
import com.qy.domain.DetailviewEntity;
import com.qy.domain.OrdersEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository(value = "bgOrderDao")
public class BgOrderDaoImpl implements BgOrderDao{
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public List<OrdersEntity> getList(OrdersEntity order, int page) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        ArrayList<String> arr=new ArrayList<>();
        HashMap<String,String>map=new HashMap<>();
        if(order.getoSendstate().length()>0){
            map.put("oSendstate",order.getoSendstate());
            arr.add("oSendstate");
        }
        if(order.getGgName().length()>0){
            map.put("ggName",order.getGgName());
            arr.add("ggName");
        }
        StringBuffer str=new StringBuffer("from OrdersEntity where 1=1 ");
        if(arr.size()==0){
            Query query=session.createQuery(str.toString());
           List<OrdersEntity> list=query.setFirstResult((page-1)*3).setMaxResults(3).list();
           return  list;
        }else  if(arr.size()==1&&order.getGgName().length()==0){
              str.append(" and oSendstate="+"'"+order.getoSendstate()+"'");
        }else if(arr.size()==1&&order.getoSendstate().length()==0){
            str.append(" and ggName like "+"'%"+order.getGgName()+"%'");
        }else {
            str.append(" and oSendstate="+"'"+order.getoSendstate()+"'"+" and ggName like "+"'%"+order.getGgName()+"%'");
        }
         Query query=session.createQuery(str.toString());
         List<OrdersEntity>list=query.setFirstResult((page-1)*page).setMaxResults(3).list();
         return list;
    }

    @Override
    //修改发送状态
    public boolean editSend(OrdersEntity order) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        session.createQuery("update OrdersEntity set oSendstate=? where oId=?").setParameter(0,"已发货").setParameter(1,order.getoId()).executeUpdate();
        return true;
    }

    @Override
    //查询订单详情表
    public List<DetailviewEntity> list(DetailviewEntity detail) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        List<DetailviewEntity> list=session.createQuery("from DetailviewEntity where oId=?").setParameter(0,detail.getoId()).list();
        return list;
    }

    //setter方法
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
