package com.qy.service;

import com.qy.domain.GoodsEntity;

import java.util.List;

public interface FwGoodsService {
    public List<GoodsEntity> findGoodsRecommend();
    public GoodsEntity findOne(GoodsEntity goodsEntity);
}
