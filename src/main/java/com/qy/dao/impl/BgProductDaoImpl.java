package com.qy.dao.impl;

import com.qy.dao.BgProductDao;
import com.qy.domain.ProductEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository(value = "bgProductDao")
public class BgProductDaoImpl implements BgProductDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public void addProduct(ProductEntity product) {
        hibernateTemplate.save(product);
    }

    @Override
    public void editProduct(ProductEntity product) {
       Session session=hibernateTemplate.getSessionFactory().openSession();
       //session.createQuery("update ProductEntity set pStyle=?,pName=?, pPackage=?,pWeight=?,pTryeat=?,pUnit=? where pNum=?").setParameter(0,product.getpStyle()).setParameter(1,product.getpName()).setParameter(2,product.getpPackage()).setParameter(3,product.getpWeight()).setParameter(4,product.getpTryeat()).setParameter(5,product.getpUnit()).setParameter(6,product.getpNum()).executeUpdate();
        List<ProductEntity> list=session.createQuery("from ProductEntity where pNum=?").setParameter(0,product.getpNum()).list();
        product.setpId(list.get(0).getpId());
        hibernateTemplate.update(product);
    }

    @Override
    public void deleteProduct(ProductEntity product) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        session.createQuery("delete ProductEntity where pId=?").setParameter(0,product.getpId()).executeUpdate();
        //session.createSQLQuery("delete ")
    }

    @Override
    public List<ProductEntity> getList(ProductEntity product, int page) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
       List<String> key= new ArrayList<String>();
        HashMap<String,String> map=new HashMap<String,String>();
        if(product.getpName().length()>0){
            map.put("pName",product.getpName());
            key.add("pName");
        }
        if(product.getpStyle().length()>0){
             map.put("pStyle",product.getpStyle());
             key.add("pStyle");
        }
        StringBuffer str=new StringBuffer("from ProductEntity where 1=1");
        if(key.size()==0){
           Query query=session.createQuery(str.toString());
            query.setFirstResult((page-1)*3).setMaxResults(3);
            List<ProductEntity>list= query.list();
            return list;
        }else if(key.size()==1&&product.getpName().length()>0){
            str.append(" and pName="+"'"+ product.getpName()+"'");
        }else if(key.size()==1&&product.getpStyle().length()>0){
            str.append(" and pStyle="+"'"+product.getpStyle()+"'");
        }else {
            str.append(" and pName="+"'"+ product.getpName()+"'"+" and pStyle="+"'"+product.getpStyle()+"'");
        }
        Query query=session.createQuery(str.toString());
        query.setFirstResult((page-1)*3).setMaxResults(3);
        List<ProductEntity>list= query.list();
        return list;
    }
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
