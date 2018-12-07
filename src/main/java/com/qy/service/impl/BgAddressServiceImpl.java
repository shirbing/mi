package com.qy.service.impl;

import com.qy.dao.BgAddressDao;
import com.qy.domain.GetgoodEntity;
import com.qy.domain.UserEntity;
import com.qy.service.BgAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BgAddressServiceImpl implements BgAddressService {
    @Resource
    private BgAddressDao bgAddressDao;



    @Override
    public boolean saveAddress(GetgoodEntity getgoodEntity) {
        return bgAddressDao.saveAddress(getgoodEntity);
    }

    @Override
    public boolean deleteAddress(GetgoodEntity getgoodEntity) {
        return bgAddressDao.deleteAddress(getgoodEntity);
    }

    @Override
    public boolean updateAddress(GetgoodEntity getgoodEntity) {
        return bgAddressDao.updateAddress(getgoodEntity);
    }

    @Override
    public List<GetgoodEntity> listAddress(int currentpage, UserEntity userEntity) {
        return bgAddressDao.listAddress(currentpage,userEntity);
    }

    @Override
    public boolean defaultAddress(GetgoodEntity getgoodEntity) {
        return bgAddressDao.defaultAddress(getgoodEntity);
    }
//set
    public void setBgAddressDao(BgAddressDao bgAddressDao) {
        this.bgAddressDao = bgAddressDao;
    }
}
