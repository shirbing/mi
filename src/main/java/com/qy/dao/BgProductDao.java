package com.qy.dao;

import com.qy.domain.ProductEntity;

import java.util.List;

public interface BgProductDao {
    //添加产品
     public abstract void addProduct(ProductEntity product);
    //编辑产品
    public abstract void editProduct(ProductEntity product);
    //删除产品
    public void deleteProduct(ProductEntity product);
    //产品列表
    public List<ProductEntity> getList(ProductEntity product, int page);

}
