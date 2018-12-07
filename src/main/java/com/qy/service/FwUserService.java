package com.qy.service;

import com.qy.domain.UserEntity;

public interface FwUserService {
    public boolean toLogin(UserEntity userEntity);
    public boolean userNameIsExist(UserEntity userEntity);
    public boolean saveUser(UserEntity userEntity);
    public boolean isState(UserEntity userEntity);
    public boolean updateUser(UserEntity userEntity, UserEntity userEntity1);
}
