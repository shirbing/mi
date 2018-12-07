package com.qy.service;

import com.qy.domain.GoodsEntity;
import com.qy.domain.ProductEntity;

import java.util.List;

public interface BgGoodsService {
    public boolean saveGoods(GoodsEntity goodsEntity);
    public boolean updateGoods(GoodsEntity goodsEntity);
    public List<GoodsEntity> findAllGoods();
    public boolean goodsNumIsExist(GoodsEntity goodsEntity);
    public boolean productIsExist(ProductEntity productEntity);
    public boolean deteleGoods(GoodsEntity goodsEntity);
    public boolean upGoods(GoodsEntity goodsEntity);
    public boolean lowGoods(GoodsEntity goodsEntity);
    public boolean recommendGoods(GoodsEntity goodsEntity);
    public boolean noRecommedGoods(GoodsEntity goodsEntity);
    public List<GoodsEntity> findSearchGoods(GoodsEntity goodsEntity,ProductEntity productEntity,int currentPage);
    public List<ProductEntity> findPnum();
}
