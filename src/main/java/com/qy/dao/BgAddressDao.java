package com.qy.dao;

import com.qy.domain.GetgoodEntity;
import com.qy.domain.UserEntity;

import java.util.List;

public interface BgAddressDao {
    public boolean saveAddress(GetgoodEntity getgoodEntity);
    public boolean deleteAddress(GetgoodEntity getgoodEntity);
    public boolean updateAddress(GetgoodEntity getgoodEntity);
    public List<GetgoodEntity>listAddress(int currentpage, UserEntity userEntity);
    public boolean defaultAddress(GetgoodEntity getgoodEntity);
}
