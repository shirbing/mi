package com.qy.service;

import com.qy.domain.ShopcarEntity;

import java.util.List;

public interface FwShoppingCarService {
    //添加购物车
    public boolean addShoppingCar(ShopcarEntity shop);
    //删除购物车
    public boolean delete(ShopcarEntity shop);
    //查询购物车，根据名字
    public List<ShopcarEntity> getList(ShopcarEntity shop);
    //更新购物车
    public boolean update(ShopcarEntity shop);
    //查询购物车，在商品列表总
    public List<ShopcarEntity> list(ShopcarEntity shopcarEntity);
}
