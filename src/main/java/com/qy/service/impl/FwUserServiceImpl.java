package com.qy.service.impl;

import com.qy.dao.FwUserDao;
import com.qy.domain.UserEntity;
import com.qy.service.FwUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "FwUserService")
public class FwUserServiceImpl implements FwUserService {
    @Autowired
    @Qualifier(value = "FwUserDao")
    private FwUserDao fwUserDao;

    public void setFwUserDao(FwUserDao fwUserDao) {
        this.fwUserDao = fwUserDao;
    }

    @Override
    public boolean toLogin(UserEntity userEntity) {
        return fwUserDao.toLogin(userEntity);
    }

    @Override
    public boolean userNameIsExist(UserEntity userEntity) {
        return fwUserDao.userNameIsExist(userEntity);
    }

    @Override
    public boolean saveUser(UserEntity userEntity) {
        return fwUserDao.saveUser(userEntity);
    }

    @Override
    public boolean isState(UserEntity userEntity) {
        return fwUserDao.isState(userEntity);
    }

    @Override
    public boolean updateUser(UserEntity userEntity, UserEntity userEntity1) {
        return fwUserDao.updateUser(userEntity,userEntity1);
    }

    @Override
    public UserEntity personInfo(UserEntity userEntity) {
        return fwUserDao.personInfo(userEntity);
    }
}
