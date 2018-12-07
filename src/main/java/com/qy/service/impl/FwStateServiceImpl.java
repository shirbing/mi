package com.qy.service.impl;

import com.qy.dao.FwStateDao;
import com.qy.domain.DetailviewEntity;
import com.qy.domain.UserEntity;
import com.qy.service.FwStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "fwStateService")
public class FwStateServiceImpl implements FwStateService {
    @Autowired
    @Qualifier(value = "fwStateDao")
    private FwStateDao fwStateDao;
    @Override
    public List<DetailviewEntity> list(int page, UserEntity userEntity) {
        return fwStateDao.list(page,userEntity);
    }
    @Override
    public List<DetailviewEntity> find(int page,UserEntity userEntity) {
        return fwStateDao.find(page,userEntity);
    }
    @Override
    public List<DetailviewEntity> getList(int page, UserEntity userEntity) {
        return fwStateDao.getList(page,userEntity);
    }
    public void setFwStateDao(FwStateDao fwStateDao) {
        this.fwStateDao = fwStateDao;
    }
}
