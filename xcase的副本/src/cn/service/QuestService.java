package cn.service;

import cn.domain.Quest;


import java.util.List;
import java.util.Map;

public interface QuestService {

    /**
     * 用户获取试题
     */
    public List<Quest> getText(int id );

    /**
     * 阅卷的方法
     * @param text
     * @param map
     * @return
     */
    public Integer getScore(List<Quest> text, Map<String, String[]> map);

    /**
     * 查询所有
     * @return
     */
    List<Quest> findAll(int id);
}
