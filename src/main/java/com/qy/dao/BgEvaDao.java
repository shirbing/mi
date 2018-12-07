package com.qy.dao;

import com.qy.domain.EvaluationEntity;

import java.util.List;

public interface BgEvaDao {
    public List<EvaluationEntity> findEva(int currentPage);
    public boolean saveReply(EvaluationEntity evaluationEntity,String Reply);
    public List<EvaluationEntity> findSearchEval(Double minStar, Double maxStar, String gNum, int page,String eReply);
    public List<EvaluationEntity> findOneEval(String gNum);


}
