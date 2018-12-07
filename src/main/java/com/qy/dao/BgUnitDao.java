package com.qy.dao;

import com.qy.domain.UnitEntity;

import java.util.List;

public interface BgUnitDao {
    //添加单位
    public void addUnit(UnitEntity unit);
    //删除单位
    public void delete(UnitEntity unit);
    //查询列表
    public List<UnitEntity> getList(int page);
}
