package com.qy.dao.impl;

import com.qy.dao.BgAddressDao;
import com.qy.domain.GetgoodEntity;
import com.qy.domain.UserEntity;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BgAddressDaoImpl implements BgAddressDao {
    @Resource
    private HibernateTemplate hibernateTemplate;

//新增
    @Override
    public boolean saveAddress(GetgoodEntity getgoodEntity) {
        System.out.println(getgoodEntity);
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        session.save(getgoodEntity);
        GetgoodEntity getgoodEntity1=(GetgoodEntity)session.createQuery("from GetgoodEntity where ggId=?").setParameter(0,getgoodEntity.getGgId()).uniqueResult();
        if (getgoodEntity1==null){
            return true;
        }
        return false;
    }
//删除
    @Override
    public boolean deleteAddress(GetgoodEntity getgoodEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        session.delete(getgoodEntity);
        GetgoodEntity getgoodEntity1=(GetgoodEntity)session.createQuery("from GetgoodEntity where ggId=?").setParameter(0,getgoodEntity.getGgId()).uniqueResult();
        if (getgoodEntity1!=null){
            return true;
        }
        return false;
    }
//修改
    @Override
    public boolean updateAddress(GetgoodEntity getgoodEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        session.update(getgoodEntity);
        return false;
    }
//地址列表
    @Override
    public List<GetgoodEntity> listAddress(int currentpage, UserEntity userEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        List<GetgoodEntity>list=session.createQuery("from GetgoodEntity where uName=?").setParameter(0,userEntity.getuName()).setFirstResult((currentpage-1)*3).setMaxResults(3).list();
        return list;
    }
//设为默认
    @Override
    public boolean defaultAddress(GetgoodEntity getgoodEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        List<GetgoodEntity>list= session.createQuery("from GetgoodEntity").list();
        for (GetgoodEntity tmp:list) {
            if(tmp.getGgId()==getgoodEntity.getGgId()){
                tmp.setGgState("是");
            }else{
                tmp.setGgState("否");

            }
            session.save(tmp);
        }
        return false;
    }
//    set
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
