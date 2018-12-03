package com.qy.dao.impl;

import com.qy.dao.BgGoodsDao;
import com.qy.domain.GoodsEntity;
import com.qy.domain.ProductEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "BgGoodsDao")
public class BgGoodsDaoImpl implements BgGoodsDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    //新增
    @Override
    public boolean saveGoods(GoodsEntity goodsEntity) {
        Session session= hibernateTemplate.getSessionFactory().getCurrentSession();
        session.save(goodsEntity);
        GoodsEntity goods=(GoodsEntity) session.createQuery("from GoodsEntity where gNum=?").setParameter(0, goodsEntity.getgNum()).uniqueResult();
        if(goods!=null){
            return true;
        }
        return false;
    }
    //编辑
    @Override
    public boolean updateGoods(GoodsEntity goodsEntity) {
        Session session= hibernateTemplate.getSessionFactory().getCurrentSession();
        GoodsEntity goods=(GoodsEntity) session.createQuery("from GoodsEntity where gNum=?").setParameter(0, goodsEntity.getgNum()).uniqueResult();
        goods.setgNum(goodsEntity.getgNum());
        goods.setgName(goodsEntity.getgName());
        goods.setgPrice(goodsEntity.getgPrice());
        goods.setgDiscount(goodsEntity.getgDiscount());
        goods.setgOffer(goodsEntity.getgOffer());
        goods.setgInventory(goodsEntity.getgInventory());
        goods.setgImg(goodsEntity.getgImg());
        goods.setgDetail(goodsEntity.getgDetail());
        goods.setgTryeat(goodsEntity.getgTryeat());
        session.update(goods);
        return true;
    }
    //查询
    @Override
    public List<GoodsEntity> findAllGoods(int currentPage) {
        Session session= hibernateTemplate.getSessionFactory().getCurrentSession();
        List<GoodsEntity> goodsEntityList=session.createQuery("from GoodsEntity order by gId desc ").setFirstResult((currentPage-1)*3).setMaxResults(3).list();
        return goodsEntityList;
    }


    //验证商品编号是否存在
    @Override
    public boolean goodsNumIsExist(GoodsEntity goodsEntity) {
        Session session= hibernateTemplate.getSessionFactory().getCurrentSession();
        GoodsEntity goods=(GoodsEntity) session.createQuery("from GoodsEntity where gNum=? ").setParameter(0, goodsEntity.getgNum()).uniqueResult();
        if(goods!=null) {
            return true;
        }
        return false;
    }
    //验证产品是否存在
    @Override
    public boolean productIsExist(ProductEntity productEntity) {
        Session session= hibernateTemplate.getSessionFactory().getCurrentSession();
        ProductEntity goods=(ProductEntity) session.createQuery("from ProductEntity where pNum=? ").setParameter(0, productEntity.getpNum()).uniqueResult();
        if(goods!=null) {
            return true;
        }
        return false;
    }
    //删除商品
    @Override
    public boolean deteleGoods(GoodsEntity goodsEntity) {
        Session session= hibernateTemplate.getSessionFactory().getCurrentSession();
        GoodsEntity goods=(GoodsEntity) session.createQuery("from GoodsEntity where gNum=? ").setParameter(0, goodsEntity.getgNum()).uniqueResult();
        session.delete(goods);
        return true;
    }
    //上架
    @Override
    public boolean upGoods(GoodsEntity goodsEntity) {
        Session session= hibernateTemplate.getSessionFactory().getCurrentSession();
        GoodsEntity goods=(GoodsEntity) session.createQuery("from GoodsEntity where gNum=? ").setParameter(0, goodsEntity.getgNum()).uniqueResult();
        goods.setgState("上架");
        session.update(goods);
        return true;
    }
    //下架
    @Override
    public boolean lowGoods(GoodsEntity goodsEntity) {
        Session session= hibernateTemplate.getSessionFactory().getCurrentSession();
        GoodsEntity goods=(GoodsEntity) session.createQuery("from GoodsEntity where gNum=? ").setParameter(0, goodsEntity.getgNum()).uniqueResult();
        goods.setgState("下架");
        session.update(goods);
        return true;
    }
//推荐
    @Override
    public boolean recommendGoods(GoodsEntity goodsEntity) {
        Session session= hibernateTemplate.getSessionFactory().getCurrentSession();
        GoodsEntity goods=(GoodsEntity) session.createQuery("from GoodsEntity where gNum=? ").setParameter(0, goodsEntity.getgNum()).uniqueResult();
        goods.setgRecommend("是");
        session.update(goods);
        return true;
    }
//不推荐
    @Override
    public boolean noRecommedGoods(GoodsEntity goodsEntity) {
        Session session= hibernateTemplate.getSessionFactory().getCurrentSession();
        GoodsEntity goods=(GoodsEntity) session.createQuery("from GoodsEntity where gNum=? ").setParameter(0, goodsEntity.getgNum()).uniqueResult();
        goods.setgRecommend("否");
        session.update(goods);
        return true;
    }

    @Override
    public List<GoodsEntity> findSearchGoods(GoodsEntity goodsEntity, ProductEntity productEntity,int currentPage) {
        /*Session session= hibernateTemplate.getSessionFactory().getCurrentSession();*/
        System.out.println("-------------------");
        List<GoodsEntity> goodsEntityList=hibernateTemplate.findByExample(goodsEntity,(currentPage-1)*3,3);

       /* List<GoodsEntity> goodsEntityList=session.createQuery("from GoodsEntity order by gId desc ").setFirstResult((currentPage-1)*3).setMaxResults(3).list();
*/
        return goodsEntityList;
    }

    @Override
    public List<ProductEntity> findPnum() {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        List<ProductEntity> goodsEntityList= session.createQuery("from ProductEntity").list();
        return goodsEntityList;
    }


}
