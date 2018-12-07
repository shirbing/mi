package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.qy.domain.UnitEntity;
import com.qy.service.BgUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/unit")
public class BgUnitController {
    @Autowired
    @Qualifier(value ="bgUnitService" )
    private BgUnitService bgUnitService;
    @RequestMapping("/add")
    @ResponseBody
    public String add(UnitEntity unit) {
        bgUnitService.addUnit(unit);
        return JSON.toJSONString("true");
    }
    @RequestMapping("/list")
    @ResponseBody
    public String getList(int page){
        List<UnitEntity>list=bgUnitService.getList(page);
        return JSON.toJSONString(list);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(UnitEntity unit){
        bgUnitService.delete(unit);
        return JSON.toJSONString("true");
    }
    public void setBgUnitService(BgUnitService bgUnitService) {
        this.bgUnitService = bgUnitService;
    }
}
