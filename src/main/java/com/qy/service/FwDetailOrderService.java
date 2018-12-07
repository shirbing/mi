package com.qy.service;

import com.qy.domain.DetailviewEntity;

import java.util.List;

//订单详情表
public interface FwDetailOrderService {
    //订单详情表
    public List<DetailviewEntity> getList(DetailviewEntity detail);
}
