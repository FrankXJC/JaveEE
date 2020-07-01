package cn.dao.impl;

import cn.Utils.JDBCUtils;
import cn.dao.UserDao;
import cn.domain.Quest;
import cn.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class UserDaoImpl implements UserDao {


    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findUserByUP(User user) {
        User user1 =null;
        try {
            String sql = "select * from user where username = ? and password = ?";
            user1 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),  user.getUsername(), user.getPassword());
            return user1;
        } catch (DataAccessException e) {
            e.printStackTrace();
            //查询不到时会报错，出现错误时返回空值
            return user1;
        }
    }



    @Override
    public void saveUser(User user) {
        String sql = "INSERT INTO USER VALUES (NULL,?,?,?,?,?,?,?,'Y',null);";
        int update = template.update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getSex(), user.getAge(), user.getPhoneNumber(),
                user.getAddress()
        );


    }

    @Override
    public void addUserToBlack(int id) {
        String sql = "UPDATE USER SET STATUS='N' WHERE uid = ?;";
        int update = template.update(sql,id);
    }

    @Override
    public List<User> findBlackUser() {
        String sql = "select * from user where STATUS='N' ";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

}
