package com.qy.service.impl;

import com.qy.dao.BgLogisticsDao;
import com.qy.domain.LogisticsEntity;
import com.qy.service.BgLogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "bgLogisticsService")
public class BgLogisticsServiceImpl implements BgLogisticsService {
    @Autowired
    @Qualifier(value = "bgLogisticsDao")
    private BgLogisticsDao bgLogisticsDao;

    @Override
    public Boolean add(LogisticsEntity log) {
        return bgLogisticsDao.add(log);
    }
   //setter方法
   public void setBgLogisticsDao(BgLogisticsDao bgLogisticsDao) {
       this.bgLogisticsDao = bgLogisticsDao;
   }
}
