package com.qy.dao.impl;

import com.qy.dao.BgAdminMgeDao;
import com.qy.domain.AdminEntity;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BgAdminMgeDaoImpl implements BgAdminMgeDao {
    @Resource
    private HibernateTemplate hibernateTemplate;


//添加管理员
    @Override
    public boolean BgAdminAdd(AdminEntity adminEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        session.save(adminEntity);
        List<AdminEntity>list=session.createQuery("from AdminEntity").list();
        for (AdminEntity tmp:list) {
            if (tmp.getaName().equals(adminEntity.getaName())){
                return true;
            }
        }


        return false;
    }
//列表分页
    @Override
    public List<AdminEntity> BgAdminList(int currentpage) {

        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
       List<AdminEntity> list=session.createQuery("from AdminEntity").setFirstResult((currentpage-1)*3).setMaxResults(3).list();


        return list;
    }
//删除管理员
    @Override
    public boolean BgAdmindelete(AdminEntity adminEntity) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        session.delete(adminEntity);
        AdminEntity adminEntity1= (AdminEntity)session.createQuery("from AdminEntity where aId=?").setParameter(0,adminEntity.getaId()).uniqueResult();
            if(adminEntity1==null){
                return true;
            }

        return false;
    }



//    set方法
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
