package com.qy.dao.impl;

import com.qy.dao.BgEvaDao;
import com.qy.domain.EvaluationEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository(value = "BgEvaDao")
public class BgEvaDaoImpl implements BgEvaDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<EvaluationEntity> findEva(int currentPage) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        List<EvaluationEntity> evaluationEntityList= session.createQuery("from EvaluationEntity ").setFirstResult((currentPage-1)*5).setMaxResults(5).list();

       /*String a=Long.toString( new Date().getTime());
        System.out.println(a);*/
        return evaluationEntityList;
    }

    @Override
    public boolean saveReply(EvaluationEntity evaluationEntity, String Reply) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        EvaluationEntity evaluationEntity1=(EvaluationEntity)session.createQuery("from EvaluationEntity where eId=?").setParameter(0,evaluationEntity.geteId()).uniqueResult();
        evaluationEntity1.seteReply(Reply);
        session.save(evaluationEntity1);
        return true;
    }

    @Override
    public List<EvaluationEntity> findSearchEval(Double minStar, Double maxStar, String gNum,int page,String eReply) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        ArrayList<String> arr=new ArrayList<>();
        HashMap<String,String> map=new HashMap<>();
        if(minStar!=null&&maxStar!=null){
            map.put("minStar",minStar.toString());
            arr.add("minStar");
        }
        if(gNum.length()>0){
            map.put("gNum",gNum);
            arr.add("gNum");
        }
        if(eReply.length()>0){
            map.put("eReply",eReply);
            arr.add("eReply");
        }
        StringBuffer str=new StringBuffer("from EvaluationEntity where 1=1 ");
        if(arr.size()==0){

        }else if(arr.size()==1&&(minStar==null||maxStar==null)&&gNum.length()==0){
            if(eReply.equals("已回复")){
                str.append("and eReply !="+"''");
            }else{
                str.append("and eReply="+"''");
            }
        }else if(arr.size()==1&&gNum.length()==0&&eReply.length()==0){
            str.append("and eStar between "+"'"+minStar+"'"+" and "+"'"+maxStar+"'");
        }else if(arr.size()==1&&(minStar==null||maxStar==null)&&eReply.length()==0){
            str.append("and gNum="+"'"+gNum+"'");
        }else if(arr.size()==2&&gNum.length()==0){
            if(eReply.equals("已回复")){
                str.append("and eReply !="+"''"+" and eStar between "+"'"+minStar+"'"+" and "+"'"+maxStar+"'");
            }else{
                str.append("and eReply="+"''"+" and eStar between "+"'"+minStar+"'"+" and "+"'"+maxStar+"'");
            }

        }else if(arr.size()==2&&(minStar==null||maxStar==null)){

            if(eReply.equals("已回复")){
                str.append("and gNum="+"'"+gNum+"'"+" and eReply !="+"''");
            }else{
                str.append("and gNum="+"'"+gNum+"'"+" and eReply="+"''");
            }

        }else if(arr.size()==2&&eReply.length()==0){
            str.append("and eStar between "+"'"+minStar+"'"+" and "+"'"+maxStar+"'"+" and gNum="+gNum);
        }else {
            if(eReply.equals("已回复")){
                str.append("and eReply !="+"''"+" and eStar between"+"'"+minStar+"'"+" and "+"'"+maxStar+"'"+" and gNum="+"'"+gNum+"'");

            }else{
                str.append("and eReply="+"''"+" and eStar between"+"'"+minStar+"'"+" and "+"'"+maxStar+"'"+" and gNum="+"'"+gNum+"'");
            }
        }
        List<EvaluationEntity> list= (List<EvaluationEntity>) session.createQuery(str.toString()).setFirstResult((page-1)*5).setMaxResults(5).list();
        return list;


    }

    @Override
    public List<EvaluationEntity> findOneEval(String gNum) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        List<EvaluationEntity> list=session.createQuery("from EvaluationEntity where gNum=?").setParameter(0,gNum).list();
        return list;
    }
}
