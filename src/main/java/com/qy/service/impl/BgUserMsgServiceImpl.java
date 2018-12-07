package com.qy.service.impl;

import com.qy.dao.BgUserMsgDao;
import com.qy.domain.UserEntity;
import com.qy.service.BgUserMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bgUserMsgService")
public class BgUserMsgServiceImpl implements BgUserMsgService {
    @Autowired
    @Qualifier(value = "bgUserMsgDao")
    private BgUserMsgDao bgUserMsgDao;
    @Override
    //用户管理
    public List<UserEntity> getList(UserEntity user, int currentpage, String starttime, String endtime) {
        return bgUserMsgDao.getList(user,currentpage,starttime,endtime);
    }

    @Override
    public boolean deleteUser(UserEntity userEntity) {
        return bgUserMsgDao.deleteUser(userEntity);
    }

    //setter方法
    public void setBgUserMsgDao(BgUserMsgDao bgUserMsgDao) {
        this.bgUserMsgDao = bgUserMsgDao;
    }
}
