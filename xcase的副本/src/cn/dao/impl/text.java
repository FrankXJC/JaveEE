package cn.dao.impl;

import cn.domain.Admin;
import cn.domain.GetSelectQuestId;
import cn.domain.Quest;
import cn.domain.Score;
import cn.service.QuestService;
import cn.service.impl.AdminServiceImpl;
import cn.service.impl.QuestServiceImpl;
import cn.service.impl.ScoreServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class text {
    public static void main(String[] args) {
//        List<Quest> javaText = new QuestServiceImpl().getJavaText();
//        System.out.println(javaText);

//        ArrayList<Integer> textNumbers = new GetSelectQuestId().getTextNumbers(1,20);
//        System.out.println(textNumbers);

//        Score score = new Score(2, 3, 55);
//        new ScoreServiceImpl().saveScore(score);

//        Admin admin = new Admin();
//        admin.setA_name("123");
//        admin.setA_password("123");
//        boolean select = new AdminServiceImpl().select(admin);
//        System.out.println(select);
//        QuestService service = new QuestServiceImpl();
//        List<Quest> text = service.findAll(2);
//        System.out.println(text);

        new UserDaoImpl().addUserToBlack(1);
    }
}
