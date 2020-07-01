package cn.dao.impl;

import cn.Utils.JDBCUtils;
import cn.dao.QuestDao;
import cn.domain.Quest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class QuestDaoImpl implements QuestDao {

    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Quest> findAll(int id) {
        String sql = null;
        switch (id){
            case 1:
                sql = "select * from matter_java ";
                break;
            case 2:
                sql = "select * from matter_ui ";
                break;
        }
        List<Quest> text = template.query(sql, new BeanPropertyRowMapper<Quest>(Quest.class));
        return text;
    }

    @Override
    public Quest findById(int id, int qid) {
        String sql = null;
        switch (id){
            case 1:
                sql = "select * from matter_java where id = ? ";
                break;
            case 2:
                sql = "select * from matter_ui where id = ? ";
                break;
        }
        return template.queryForObject(sql, new BeanPropertyRowMapper<Quest>(Quest.class), qid);
    }




}
