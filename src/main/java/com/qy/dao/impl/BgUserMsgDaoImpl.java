package com.qy.dao.impl;

import com.qy.dao.BgUserMsgDao;
import com.qy.domain.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository(value = "bgUserMsgDao")
public class BgUserMsgDaoImpl implements BgUserMsgDao {
    @Resource
    private HibernateTemplate hibernateTemplate;
    @Override
    //用户管理,查询用户信息
    public List<UserEntity> getList(UserEntity user, int currentpage, String starttime, String endtime) {
        System.out.println();
        Session session= hibernateTemplate.getSessionFactory().getCurrentSession();
        List<String> key= new ArrayList<String>();
        HashMap<String,String> map=new HashMap<String,String>();
        if(user.getuName().length()>0){
            map.put("uName",user.getuName());
            key.add("uName");
        }
        if(user.getuState().length()>0){
            map.put("uState",user.getuState());
            key.add("uState");
        }
        if(starttime.length()>0){
            map.put("starttime",starttime);
            key.add("starttime");
        }
        StringBuffer str=new StringBuffer("from UserEntity where 1=1 ");
        if(key.size()==0){

        }else if(key.size()==1&&starttime.length()==0&&user.getuName().length()==0){
            str.append("and uState="+"'"+user.getuState()+"'");
        }else if(key.size()==1&&user.getuState().length()==0&&user.getuName().length()==0){
            str.append("and uRegister between "+"'"+starttime+"'"+" and "+"'"+endtime+"'");
        }else if(key.size()==1&&user.getuState().length()==0&&starttime.length()==0){
            str.append("and uName="+"'"+user.getuName()+"'");
        }else if(key.size()==2&&user.getuName().length()==0){
            str.append("and uState="+"'"+user.getuState()+"'"+" and uRegister between "+"'"+starttime+"'"+" and "+"'"+endtime+"'");
        }else if(key.size()==2&&starttime.length()==0){
            str.append("and uState="+"'"+user.getuState()+"'"+" and uName="+"'"+user.getuName()+"'");
        }else if(key.size()==2&&user.getuState().length()==0){

            str.append("and uRegister between "+"'"+starttime+"'"+" and "+"'"+endtime+"'"+" and uName="+user.getuName());
        }else {

            str.append("and uState="+"'"+user.getuState()+"'"+" and uRegister between"+"'"+starttime+"'"+" and "+"'"+endtime+"'"+" and uName="+"'"+user.getuName()+"'");
        }
      /*  Query query=session.createQuery(str.toString());
        query.setFirstResult((currentpage-1)*3).setMaxResults(3);
        List<UserEntity>list= query.list();*/
      List<UserEntity> list= (List<UserEntity>) session.createQuery(str.toString()).setFirstResult((currentpage-1)*3).setMaxResults(3).list();
        return list;
    }

    @Override
    public boolean deleteUser(UserEntity userEntity) {
        System.out.println(userEntity.getuId());
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        UserEntity userEntity1=(UserEntity) session.createQuery("from UserEntity where uId=?").setParameter(0,userEntity.getuId()).uniqueResult();
        if (userEntity1.getuState().equals("启用")){
            userEntity1.setuState("禁用");
        }else{
            userEntity1.setuState("启用");
        }
        session.save(userEntity1);
        if (userEntity1.getuState().equals(userEntity.getuState())){
            return true;
        }
        return false;
    }


    //setter方法
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
