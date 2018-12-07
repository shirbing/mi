package com.qy.service.impl;

import com.qy.dao.FwGoodsDao;
import com.qy.domain.GoodsEntity;
import com.qy.service.FwGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "FwGoodsService")
public class FwGoodsServiceImpl implements FwGoodsService {
    @Autowired
    @Qualifier(value = "FwGoodsDao")
    private FwGoodsDao fwGoodsDao;

    public void setFwGoodsDao(FwGoodsDao fwGoodsDao) {
        this.fwGoodsDao = fwGoodsDao;
    }

    @Override
    public List<GoodsEntity> findGoodsRecommend() {
        return fwGoodsDao.findGoodsRecommend();
    }

    @Override
    public GoodsEntity findOne(GoodsEntity goodsEntity) {
        return fwGoodsDao.findOne(goodsEntity);
    }
}
