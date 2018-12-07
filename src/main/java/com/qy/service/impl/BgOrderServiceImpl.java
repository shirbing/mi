package com.qy.service.impl;

import com.qy.dao.BgOrderDao;
import com.qy.domain.DetailviewEntity;
import com.qy.domain.OrdersEntity;
import com.qy.service.BgOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bgOrderService")
public class BgOrderServiceImpl implements BgOrderService {
    @Autowired
    @Qualifier(value = "bgOrderDao")
    private BgOrderDao bgOrderDao;
    @Override
    public List<OrdersEntity> getList(OrdersEntity order, int page) {
        return bgOrderDao.getList(order,page);
    }

    @Override
    //修改发送状态
    public boolean editSend(OrdersEntity order) {
        return bgOrderDao.editSend(order);
    }

    @Override
    public List<DetailviewEntity> list(DetailviewEntity detail) {
        return bgOrderDao.list(detail);
    }

    //setter方法
    public void setBgOrderDao(BgOrderDao bgOrderDao) {
        this.bgOrderDao = bgOrderDao;
    }
}
