package com.qy.service.impl;

import com.qy.dao.FwOrderListDao;
import com.qy.domain.DetailviewEntity;
import com.qy.domain.GetgoodEntity;
import com.qy.domain.OrdersEntity;
import com.qy.domain.ShopcarEntity;
import com.qy.service.FwOrderListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class FwOrderListServiceImpl implements FwOrderListService {
    @Resource
    private FwOrderListDao fwOrderListDao;
    @Override
    public boolean saveOrder(OrdersEntity ordersEntity) {
      List<ShopcarEntity> list=fwOrderListDao.listshopcar(ordersEntity);
        GetgoodEntity getgoodEntity=fwOrderListDao.address(ordersEntity);

        if (list==null){
            return true;
        }else{

          for(int i=0;i<list.size();i++){
                OrdersEntity ordersEntity1=new OrdersEntity();
                ordersEntity1.setoNum(Long.toString(new Date().getTime()));//订单编号
                ordersEntity1.setgNum(list.get(i).getgNum());//商品编号
                ordersEntity1.setuName(list.get(i).getuName());//用户名
                ordersEntity1.setGgName(getgoodEntity.getGgName());//收货人姓名
                ordersEntity1.setoMoney(list.get(i).getsPrice()*list.get(i).getsNum());//金额
              System.out.println(list.get(i).getgNum());
              System.out.println(ordersEntity1.getgNum());
                //留言
                //订单详情显示图片
                fwOrderListDao.saveOrder(ordersEntity1);
        }


        }
        return false;
//        return fwOrderListDao.saveOrder(ordersEntity);

    }

    @Override
    public List<DetailviewEntity> listOrder(OrdersEntity ordersEntity, int currentpage) {
        return fwOrderListDao.listOrder(ordersEntity,currentpage);
    }

    @Override
    public boolean deleteOrder(OrdersEntity ordersEntity) {
        return fwOrderListDao.deleteOrder(ordersEntity);
    }

    @Override
    public boolean paystateOrder(OrdersEntity ordersEntity) {
        return fwOrderListDao.paystateOrder(ordersEntity);
    }

    @Override
    public boolean okOrder(OrdersEntity ordersEntity) {
        return fwOrderListDao.okOrder(ordersEntity);
    }

    @Override
    public boolean isevaluateOrder(OrdersEntity ordersEntity) {
        return fwOrderListDao.isevaluateOrder(ordersEntity);
    }








//    set
    public void setFwOrderListDao(FwOrderListDao fwOrderListDao) {
        this.fwOrderListDao = fwOrderListDao;
    }


}
