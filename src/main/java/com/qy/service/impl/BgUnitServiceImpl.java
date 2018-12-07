package com.qy.service.impl;

import com.qy.dao.BgUnitDao;
import com.qy.domain.UnitEntity;
import com.qy.service.BgUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bgUnitService")
public class BgUnitServiceImpl implements BgUnitService {
    @Autowired
    @Qualifier(value = "bgUnitDao")
    private BgUnitDao bgUnitDao;
    @Override
    //添加单位
    public void addUnit(UnitEntity unit) {
        bgUnitDao.addUnit(unit);
    }

    @Override
    //删除单位
    public void delete(UnitEntity unit) {
       bgUnitDao.delete(unit);
    }

    @Override
    public List<UnitEntity> getList(int page) {
        return bgUnitDao.getList(page);
    }

    public void setBgUnitDao(BgUnitDao bgUnitDao) {
        this.bgUnitDao = bgUnitDao;
    }
}
