package com.qy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qy.domain.EvaluationEntity;
import com.qy.service.BgEvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/BgEva")
public class BgEvaController {
@Autowired
    @Qualifier("BgEvaService")
    private BgEvaService bgEvaService;

    public void setBgEvaService(BgEvaService bgEvaService) {
        this.bgEvaService = bgEvaService;
    }
    @RequestMapping("/findEva")
    @ResponseBody
    public String findEva(int currentPage){
        List<EvaluationEntity> evaluationEntityList=bgEvaService.findEva(currentPage);
        return JSON.toJSONString(evaluationEntityList,SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/saveEva")
    @ResponseBody
    public String saveEva(EvaluationEntity evaluationEntity,String Reply){
        bgEvaService.saveReply(evaluationEntity,Reply);
        return JSON.toJSONString("true");
    }

    /*@RequestMapping("/findSearchEva")
    @ResponseBody
    public String findSearchEva(Srei){
        bgEvaService.saveReply(evaluationEntity,Reply);
        return JSON.toJSONString("true");
    }*/
    @RequestMapping("/findSearchEva")
    @ResponseBody
    public String findSearchEva(Double minStar, Double maxStar,String gNum, int page,String eReply){

        /*调用service*/
        List<EvaluationEntity> list = bgEvaService.findSearchEval(minStar,maxStar,gNum,page,eReply);

        return JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/findOneEval")
    @ResponseBody
    public String findOneEval(String gNum){
        /*调用service*/

        List<EvaluationEntity> list = bgEvaService.findOneEval(gNum);
        return JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
    }





}
