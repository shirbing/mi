package com.qy.service.impl;

import com.qy.dao.BgEvaDao;
import com.qy.domain.EvaluationEntity;
import com.qy.service.BgEvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "BgEvaService")
public class BgEvaServiceImpl implements BgEvaService {
    @Autowired
    @Qualifier("BgEvaDao")
    private BgEvaDao bgEvaDao;

    public void setBgEvaDao(BgEvaDao bgEvaDao) {
        this.bgEvaDao = bgEvaDao;
    }


    @Override
    public List<EvaluationEntity> findEva(int currentPage) {
        return bgEvaDao.findEva(currentPage);
    }

    @Override
    public boolean saveReply(EvaluationEntity evaluationEntity, String Reply) {
        return bgEvaDao.saveReply(evaluationEntity,Reply);
    }

    @Override
    public List<EvaluationEntity> findSearchEval(Double minStar, Double maxStar, String gNum,  int page,String eReply) {
        return bgEvaDao.findSearchEval(minStar,maxStar,gNum,page,eReply);
    }

    @Override
    public List<EvaluationEntity> findOneEval(String gNum) {
        return bgEvaDao.findOneEval(gNum);
    }
}
