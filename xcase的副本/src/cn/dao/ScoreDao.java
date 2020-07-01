package cn.dao;

import cn.domain.Score;

public interface ScoreDao {

    /**
     * 保存分数
     *
     */
    void saveScore(Score score);
}
