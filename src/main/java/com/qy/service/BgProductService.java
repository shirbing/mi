package com.qy.service;


import com.qy.domain.ProductEntity;

import java.util.List;

public interface BgProductService {
    //添加产品
    public void addProduct(ProductEntity product);
    //编辑产品
    public  void editProduct(ProductEntity product);
    //删除产品
    public void  delect(ProductEntity product);
    //产品列表
    public List<ProductEntity> getList(ProductEntity product, int page);
}
