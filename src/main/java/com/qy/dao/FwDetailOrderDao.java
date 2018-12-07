package com.qy.dao;

import com.qy.domain.DetailviewEntity;

import java.util.List;

//forward的订单详情
public interface FwDetailOrderDao {
    //订单详情查询
    public List<DetailviewEntity> getList(DetailviewEntity detail);
}
