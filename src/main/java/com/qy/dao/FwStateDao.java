package com.qy.dao;

import com.qy.domain.DetailviewEntity;
import com.qy.domain.UserEntity;

import java.util.List;

public interface FwStateDao {
    //查看付款状态
    public List<DetailviewEntity> list(int page, UserEntity userEntity);
    //查看收货状态
    public List<DetailviewEntity> find(int page, UserEntity userEntity);
    //查看交易状态
    public List<DetailviewEntity> getList(int page, UserEntity userEntity);
}
