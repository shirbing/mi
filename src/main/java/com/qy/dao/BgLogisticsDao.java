package com.qy.dao;

import com.qy.domain.LogisticsEntity;

//物流
public interface BgLogisticsDao {
    //添加物流信息
    public boolean add(LogisticsEntity log);
}
