package com.qy.service.impl;

import com.qy.dao.BgProductDao;
import com.qy.domain.ProductEntity;
import com.qy.service.BgProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "bgProductService")
public class BgProductServiceImpl implements BgProductService {
    @Autowired(required = false)
    @Qualifier(value = "bgProductDao")
    private BgProductDao bgProductDao;
    @Override
    public void addProduct(ProductEntity product) {
        bgProductDao.addProduct(product);
    }

    @Override
    public void editProduct(ProductEntity product) {
       bgProductDao.editProduct(product);
    }

    @Override
    public void delect(ProductEntity product) {
        bgProductDao.deleteProduct(product);
    }

    @Override
    public List<ProductEntity> getList(ProductEntity product,int page) {
        return bgProductDao.getList(product,page);
    }

    public void setBgProductDao(BgProductDao bgProductDao) {
        this.bgProductDao = bgProductDao;
    }
}
