package com.qy.service.impl;

import com.qy.dao.FwDetailOrderDao;
import com.qy.domain.DetailviewEntity;
import com.qy.service.FwDetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

//订单详情表（forward）
@Service(value = "fwDetailOrderService")
public class FwDetailOrderServiceImpl implements FwDetailOrderService {
    @Autowired
    @Qualifier(value = "fwDetailOrderDao")
    private FwDetailOrderDao fwDetailOrderDao;
    @Override
    public List<DetailviewEntity> getList(DetailviewEntity detail) {
        return fwDetailOrderDao.getList(detail);
    }
    public void setFwDetailOrderDao(FwDetailOrderDao fwDetailOrderDao) {
        this.fwDetailOrderDao = fwDetailOrderDao;
    }
}
