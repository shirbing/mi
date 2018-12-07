package com.qy.dao;

import com.qy.domain.UserEntity;

public interface FwUserDao {
    public boolean toLogin(UserEntity userEntity);
    public boolean userNameIsExist(UserEntity userEntity);
    public boolean saveUser(UserEntity userEntity);
    public boolean isState(UserEntity userEntity);

    public boolean updateUser(UserEntity userEntity,UserEntity userEntity1);
    public UserEntity personInfo(UserEntity userEntity);

}
