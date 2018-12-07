package com.qy.service;

import com.qy.domain.UnitEntity;

import java.util.List;

public interface BgUnitService {
    //添加单位
    public void addUnit(UnitEntity unit);
    //删除单位
    public void delete(UnitEntity unit);
    //查询单位
    public List<UnitEntity> getList(int page);
}
