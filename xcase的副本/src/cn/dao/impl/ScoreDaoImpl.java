package cn.dao.impl;

import cn.Utils.JDBCUtils;
import cn.dao.ScoreDao;
import cn.domain.Score;
import org.springframework.jdbc.core.JdbcTemplate;

public class ScoreDaoImpl  implements ScoreDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public void saveScore(Score score) {
        String sql = "INSERT INTO score values (NULL,?,?,?);";
        int update = template.update(sql, score.getUid(),score.getPid(),score.getScore());
    }

}
