package com.qy.service.impl;

import com.qy.dao.FwShoppingCarDao;
import com.qy.domain.ShopcarEntity;
import com.qy.service.FwShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "fwShoppingCarService")
public class FwShoppingCarServiceImpl  implements FwShoppingCarService {
   @Autowired
   @Qualifier(value = "fwShoppingCarDao")
   private FwShoppingCarDao fwShoppingCarDao;

    @Override
    //添加购物车
    public boolean addShoppingCar(ShopcarEntity shop) {
        return fwShoppingCarDao.addShoppingCar(shop);
    }
    @Override
    //删除购物车
    public boolean delete(ShopcarEntity shop) {
        return fwShoppingCarDao.delete(shop);
    }

    @Override
    //查询购物车,根据名字
    public List<ShopcarEntity> getList(ShopcarEntity shop) {
        return fwShoppingCarDao.getList(shop);
    }

    @Override
    //更新购物车
    public boolean update(ShopcarEntity shop) {
        return fwShoppingCarDao.update(shop);
    }

    @Override
    //分页查询购物车
    public List<ShopcarEntity> list(ShopcarEntity shopcarEntity) {
        return fwShoppingCarDao.list(shopcarEntity);
    }


    public void setFwShoppingCarDao(FwShoppingCarDao fwShoppingCarDao) {
        this.fwShoppingCarDao = fwShoppingCarDao;
    }
}
