package com.qy.dao;

import com.qy.domain.GoodsEntity;

import java.util.List;

public interface FwGoodsDao {
    public List<GoodsEntity> findGoodsRecommend();
    public GoodsEntity findOne(GoodsEntity goodsEntity);
}
