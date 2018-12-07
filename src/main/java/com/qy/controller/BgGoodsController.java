package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.qy.domain.GoodsEntity;
import com.qy.domain.ProductEntity;
import com.qy.service.BgGoodsService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/BgGoods")
public class BgGoodsController {
    @Autowired
    @Qualifier(value = "BgGoodsService")
    private BgGoodsService bgGoodsService;

    public void setBgGoodsService(BgGoodsService bgGoodsService) {
        this.bgGoodsService = bgGoodsService;
    }

    @RequestMapping("/saveGoods")
    @ResponseBody
    public String saveGoods(GoodsEntity goodsEntity, ProductEntity productEntity, @RequestParam("gImg1") MultipartFile myfile, String pName, HttpServletRequest request){
        String filename=myfile.getOriginalFilename();
        goodsEntity.setgImg("images/"+filename);
        System.out.println("存在数据库里：==images/"+filename);
        String path2=request.getServletContext().getRealPath("background//images");
        System.out.println(path2);

        File destFile=new File(path2+File.separatorChar+filename);
        try {
            InputStream in =myfile.getInputStream();
            FileUtils.copyInputStreamToFile(in,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
        if (bgGoodsService.productIsExist(productEntity)) {
            if (!bgGoodsService.goodsNumIsExist(goodsEntity)) {
                if (bgGoodsService.saveGoods(goodsEntity)) {
                    i = 1;
                    return JSON.toJSONString(i);//成功
                }
                i = 2;
                return JSON.toJSONString(i);
            }
            i=3;
            return JSON.toJSONString(i);
        }
        return JSON.toJSONString(i);
    }
    //编辑商品
    @RequestMapping("/updateGoods")
    @ResponseBody
    public String updateGoods(GoodsEntity goodsEntity, ProductEntity productEntity, @RequestParam("gImg1") MultipartFile myfile, String pName, HttpServletRequest request){

        String filename=myfile.getOriginalFilename();
        goodsEntity.setgImg("images/"+filename);
        System.out.println("存在数据库里：==images/"+filename);
        String path2=request.getServletContext().getRealPath("background//images");
        System.out.println(path2);

        File destFile=new File(path2+File.separatorChar+filename);
        try {
            InputStream in =myfile.getInputStream();
            FileUtils.copyInputStreamToFile(in,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
        if (bgGoodsService.productIsExist(productEntity)) {
            if (bgGoodsService.goodsNumIsExist(goodsEntity)) {
                if (bgGoodsService.updateGoods(goodsEntity)){
                    i = 1;
                    return JSON.toJSONString(i);//成功
                }
                i = 2;
                return JSON.toJSONString(i);
            }
            i=3;
            return JSON.toJSONString(i);
        }
        return JSON.toJSONString(i);
    }
    //列取所有商品
    @RequestMapping("/findAllGoods")
    @ResponseBody
    public String findAllGoods(){
       List<GoodsEntity> goodsEntityList= bgGoodsService.findAllGoods();
        return JSON.toJSONString(goodsEntityList);
    }
    //删除商品
    @RequestMapping("/deleteGoods")
    @ResponseBody
    public String deleteGoods(GoodsEntity goodsEntity){

        int i=0;
        if(bgGoodsService.deteleGoods(goodsEntity)){
            i=1;
            return JSON.toJSONString(i);
        }
        return JSON.toJSONString(i);
    }
    //推荐商品
    @RequestMapping("/recommendGoods")
    @ResponseBody
    public String recommendGoods(GoodsEntity goodsEntity){

        int i=0;
        if(bgGoodsService.recommendGoods(goodsEntity)){
            i=1;
            return JSON.toJSONString(i);
        }
        return JSON.toJSONString(i);
    }
    //不推荐商品
    @RequestMapping("/noRecommendGoods")
    @ResponseBody
    public String noRecommendGoods(GoodsEntity goodsEntity){
        int i=0;
        if(bgGoodsService.noRecommedGoods(goodsEntity)){
            i=1;
            return JSON.toJSONString(i);
        }
        return JSON.toJSONString(i);
    }

    //上架商品
    @RequestMapping("/upGoods")
    @ResponseBody
    public String upGoods(GoodsEntity goodsEntity){

        int i=0;
        if(bgGoodsService.upGoods(goodsEntity)){
            i=1;
            return JSON.toJSONString(i);
        }
        return JSON.toJSONString(i);
    }
    //下架商品
    @RequestMapping("/lowGoods")
    @ResponseBody
    public String lowGoods(GoodsEntity goodsEntity){
        int i=0;
        if(bgGoodsService.lowGoods(goodsEntity)){
            i=1;
            return JSON.toJSONString(i);
        }
        return JSON.toJSONString(i);
    }
    @RequestMapping("/changeSearchGoods")
    @ResponseBody
    public String changeSearchGoods(GoodsEntity a, ProductEntity productEntity, int currentPage){

        GoodsEntity goodsEntity=new GoodsEntity();
        if(a.getgRecommend()!=""){
            goodsEntity.setgRecommend(a.getgRecommend());
        }
        if(a.getgState()!=""){
            goodsEntity.setgState(a.getgState());
        }
        if(a.getgTryeat()!=""){
            goodsEntity.setgTryeat(a.getgTryeat());
        }
        List<GoodsEntity> goodsEntityList= bgGoodsService.findSearchGoods(goodsEntity,productEntity, currentPage);
        return JSON.toJSONString(goodsEntityList);
    }
    @RequestMapping("/addPnum")
    @ResponseBody
    public String addPnum(){
        List<ProductEntity> goodsEntityList= bgGoodsService.findPnum();
        return JSON.toJSONString(goodsEntityList);
    }




}
