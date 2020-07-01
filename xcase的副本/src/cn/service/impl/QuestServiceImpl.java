package cn.service.impl;

import cn.dao.QuestDao;
import cn.dao.impl.QuestDaoImpl;
import cn.domain.GetSelectQuestId;
import cn.domain.Quest;
import cn.domain.Score;
import cn.service.QuestService;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestServiceImpl implements QuestService {
    private QuestDao questDao = new QuestDaoImpl();

    @Override
    public List<Quest> getText(int id) {
        //创建试题
        List<Quest> text = null;
        ArrayList<Integer> textNumbers = null;
        //随机获取xx题号
        switch (id) {
            case 1: // java
                textNumbers = new GetSelectQuestId().getTextNumbers(1, 20);
                //查找题目并将题目放入集合
                /*创建集合*/
                text = new ArrayList<Quest>();
                for (Integer textNumber : textNumbers) {
                    Quest matter_java = questDao.findById(1, textNumber);
                    text.add(matter_java);
                }break;

            case 2:   // ui
                textNumbers = new GetSelectQuestId().getTextNumbers(2, 20);
                //查找题目并将题目放入集合
                /*创建集合*/
                text = new ArrayList<Quest>();
                for (Integer textNumber : textNumbers) {
                    Quest matter_java = questDao.findById(2, textNumber);
                    text.add(matter_java);
                }break;

            case 3:  //架构师，每种十个
                textNumbers = new GetSelectQuestId().getTextNumbers(1, 10);
                //查找题目并将题目放入集合
                /*创建集合*/
                text = new ArrayList<Quest>();
                for (Integer textNumber : textNumbers) {
                    Quest matter_java = questDao.findById(1, textNumber);
                    text.add(matter_java);
                }
                ArrayList<Integer> textNumbers1 = new GetSelectQuestId().getTextNumbers(2, 10);
                for (Integer integer : textNumbers1) {
                    Quest matter_java = questDao.findById(2, integer);
                    text.add(matter_java);
                }
                break;
        }

        return text;

    }


    /**
     * 阅卷方法
     * @param text
     * @param map
     * @return
     */
    public Integer getScore(List<Quest> text, Map<String, String[]> map) {
        int v = 0;
        String str = "";
        for (Quest quest : text) {
            str+=quest.getAnswer();
        }
//        System.out.println(str);
        char[] chars = str.toCharArray();
        for (String s : map.keySet()) {
            //用户作答
            String[] strings = map.get(s);
            //题目答案
            String string = ""+chars[Integer.parseInt(s)-1];

//            System.out.println( strings[0]+"-----"+chars[Integer.parseInt(s)-1]);
            if (strings[0].equals(string)){
                v++;
            }

        }

        return v*5;
    }


    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Quest> findAll(int id){
        return questDao.findAll(id);
    };


}
