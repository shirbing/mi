package com.qy.service.impl;

import com.qy.dao.BgAdminMgeDao;
import com.qy.domain.AdminEntity;
import com.qy.service.BgAdminMgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BgAdminMgeServiceImpl implements BgAdminMgeService {
@Resource
private BgAdminMgeDao bgAdminMgeDao;



    @Override
    public boolean BgAdminAdd(AdminEntity adminEntity) {
        return bgAdminMgeDao.BgAdminAdd(adminEntity);
    }

    @Override
    public List<AdminEntity> BgAdminList(int currentpage) {
        return bgAdminMgeDao.BgAdminList(currentpage);
    }

    @Override
    public boolean BgAdmindelete(AdminEntity adminEntity) {
        return bgAdminMgeDao.BgAdmindelete(adminEntity);
    }

//set 方法
    public void setBgAdminMgeDao(BgAdminMgeDao bgAdminMgeDao) {
        this.bgAdminMgeDao = bgAdminMgeDao;
    }
}
