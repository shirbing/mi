package com.qy.dao;

import com.qy.domain.UserEntity;

import java.util.List;

public interface BgUserMsgDao {
    //用户管理
    public List<UserEntity> getList(UserEntity userEntity, int currentpage, String starttime, String endtime);
    public boolean deleteUser(UserEntity userEntity);
}
