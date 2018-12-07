package com.qy.dao.impl;

import com.qy.dao.BgUnitDao;
import com.qy.domain.UnitEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "bgUnitDao")
public class BgUnitDaoImpl implements BgUnitDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void addUnit(UnitEntity unit) {
         hibernateTemplate.save(unit);
    }

    @Override
    public void delete(UnitEntity unit) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        session.createQuery("delete UnitEntity where uId=?").setParameter(0,unit.getuId()).executeUpdate();
    }
    //查询语句
    @Override
    public List<UnitEntity> getList(int page) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        List<UnitEntity> list=session.createQuery("from UnitEntity").setFirstResult((page-1)*3).setMaxResults(3).list();
        return list;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
