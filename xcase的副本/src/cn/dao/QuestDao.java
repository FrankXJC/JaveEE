package cn.dao;

import cn.domain.Quest;

import java.util.List;

public interface QuestDao {
    /**
     * 查询所有
     * @return
     */
    List<Quest> findAll(int id);

    /**
     * 根据id查询
     * @return
     */
    Quest findById(int id,int Qid);
}
