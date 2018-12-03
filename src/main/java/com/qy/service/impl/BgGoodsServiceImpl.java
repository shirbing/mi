package com.qy.service.impl;

import com.qy.dao.BgGoodsDao;
import com.qy.domain.GoodsEntity;
import com.qy.domain.ProductEntity;
import com.qy.service.BgGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "BgGoodsService")
public class BgGoodsServiceImpl implements BgGoodsService {
    @Autowired
    @Qualifier(value = "BgGoodsDao")
    private BgGoodsDao bgGoodsDao;

    public void setBgGoodsDao(BgGoodsDao bgGoodsDao) {
        this.bgGoodsDao = bgGoodsDao;
    }

    @Override
    public boolean saveGoods(GoodsEntity goodsEntity) {
        return bgGoodsDao.saveGoods(goodsEntity);
    }

    @Override
    public boolean updateGoods(GoodsEntity goodsEntity) {
        return bgGoodsDao.updateGoods(goodsEntity);
    }

    @Override
    public List<GoodsEntity> findAllGoods(int currentPage) {
        return bgGoodsDao.findAllGoods(currentPage);
    }

    @Override
    public boolean goodsNumIsExist(GoodsEntity goodsEntity) {
        return bgGoodsDao.goodsNumIsExist(goodsEntity);
    }

    @Override
    public boolean productIsExist(ProductEntity productEntity) {
        return bgGoodsDao.productIsExist(productEntity);
    }

    @Override
    public boolean deteleGoods(GoodsEntity goodsEntity) {
        return bgGoodsDao.deteleGoods(goodsEntity);
    }

    @Override
    public boolean upGoods(GoodsEntity goodsEntity) {
        return bgGoodsDao.upGoods(goodsEntity);
    }

    @Override
    public boolean lowGoods(GoodsEntity goodsEntity) {
        return bgGoodsDao.lowGoods(goodsEntity);
    }

    @Override
    public boolean recommendGoods(GoodsEntity goodsEntity) {
        return bgGoodsDao.recommendGoods(goodsEntity);
    }

    @Override
    public boolean noRecommedGoods(GoodsEntity goodsEntity) {
        return bgGoodsDao.noRecommedGoods(goodsEntity);
    }

    @Override
    public List<GoodsEntity> findSearchGoods(GoodsEntity goodsEntity, ProductEntity productEntity,int currentPage) {
        return bgGoodsDao.findSearchGoods(goodsEntity,productEntity,currentPage);
    }

    @Override
    public List<ProductEntity> findPnum() {
        return bgGoodsDao.findPnum();
    }
}
