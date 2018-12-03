package com.qy.service;

import com.qy.domain.UserEntity;

import java.util.List;

public interface BgUserMsgService {
   //用户管理
   public List<UserEntity> getList(UserEntity user, int currentpage, String starttime, String endtime);
public boolean deleteUser(UserEntity userEntity);
}
