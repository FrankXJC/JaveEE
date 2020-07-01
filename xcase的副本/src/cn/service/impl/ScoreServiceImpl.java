package cn.service.impl;

import cn.dao.ScoreDao;
import cn.dao.impl.ScoreDaoImpl;
import cn.domain.Score;
import cn.service.ScoreService;


public class ScoreServiceImpl implements ScoreService {


    private ScoreDao scoreDao = new ScoreDaoImpl();
    /**
     * 保存分数
     */
    @Override
    public void saveScore(Score score) {
       scoreDao.saveScore(score);
    }
}
