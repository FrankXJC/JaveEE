package cn.domain;

import cn.Utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
/**
 * 获取随机题号的方法
 * 根据题目数量随机生成题号
 * set可以避免重复
 */

public class GetSelectQuestId {


    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 获取随机题号的方法
     * 根据题目数量随机生成题号
     * set可以避免重复
     */

    public ArrayList<Integer> getTextNumbers(int id,int sum) {
        String sql = null ;
        switch (id){
            case 1:
                sql = "select COUNT(*) from matter_java";
                break;
            case 2:
                sql = "select COUNT(*) from matter_ui";
                break;
        }

        int integer = template.queryForObject(sql, Integer.class);
        //2.随机生成题号
        HashSet<Integer> number =new HashSet<>();
        while (number.size() < sum) {
            Random random = new Random();
            int i = random.nextInt((integer-1));
            number.add((i+1));
        }
        ArrayList<Integer> textNumbers = new ArrayList<>(number);
        textNumbers.sort((t0, t1) -> t0-t1);
        return textNumbers;
    }

}
