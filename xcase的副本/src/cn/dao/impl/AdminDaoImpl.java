package cn.dao.impl;

import cn.Utils.JDBCUtils;
import cn.domain.Admin;
import cn.dao.AdminDao;
import cn.domain.Quest;
import cn.domain.User;
import cn.domain.UserShow;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;


public class AdminDaoImpl implements AdminDao {

    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public boolean select(Admin admin) {
        try {
            String sql = "select * from admin where a_name = ? and a_password = ?";
            Admin adm = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Admin>(Admin.class),
                    admin.getA_name(),admin.getA_password());
            return  (adm==null) ?  false:true;

        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<UserShow> findAll(int num) {
        String sql = null;
        switch (num){
            case 1:
                sql = "select * from admin_java ";break;
            case 2:
                sql = "select * from admin_ui ";break;
            case 3:
                sql = "select * from admin_jg";break;
        }

        List<UserShow> userList = template.query(sql, new BeanPropertyRowMapper<UserShow>(UserShow.class));
        return userList;


    }

    @Override
    public List<UserShow> selectA_B(int a, int b,int num) {
        String sql = null;
        switch (num){
            case 1:
                sql = "select * from admin_java where score>? and score<?";break;
            case 2:
                sql = "select * from admin_ui where score>? and score<?";break;
            case 3:
                sql = "select * from admin_jg where score>? and score<?";break;
        }
        List<UserShow> userList = template.query(sql, new BeanPropertyRowMapper<UserShow>(UserShow.class),a,b);
        return userList;
    }


    @Override
    public int findTotalCount(int start,int over,int num) {
        //1.定义模板初始化sql
        String sql = null;
        switch (num){
            case 1:
                sql = "select count(*) from admin_java where score >= ? and score <=? ";break;
            case 2:
                sql = "select count(*) from admin_ui where score >= ? and score <=? ";break;
            case 3:
                sql = "select count(*) from admin_jg where score >= ? and score <=? ";break;
        }



        return template.queryForObject(sql,Integer.class,start,over);
    }

    @Override
    public List<UserShow> findByPage(int currentPage, int rows,  int scoreStart,int scoreOver,String by,int num) {
        //1.定义模板初始化sql
        String sql = null;
        switch (num){
            case 1:
                sql = "select * from admin_java where score >= ? and score <=? ";break;
            case 2:
                sql = "select * from admin_ui where score >= ? and score <=? ";break;
            case 3:
                sql = "select * from admin_jg where score >= ? and score <=? ";break;
        }
        StringBuilder sb = new StringBuilder(sql);
        //排序方式
        if (by.equals("up")){
            sb.append("  ORDER BY score ASC");
        }if (by.equals("down")){
            sb.append("  ORDER BY score DESC");
        }
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        sql = sb.toString();
        System.out.println(sql);
        System.out.println(scoreStart+"----"+scoreOver+"----"+currentPage+"----"+rows);


        return template.query(sql,new BeanPropertyRowMapper<UserShow>(UserShow.class),scoreStart,scoreOver,currentPage,rows);
    }

    @Override
    public UserShow selectById(int id,int num) {
        String sql = null;
        switch (num){
            case 1:
                sql = "select * from admin_java where id = ?";break;
            case 2:
                sql = "select * from admin_ui where id = ?";break;
            case 3:
                sql = "select * from admin_jg where id = ?";break;
        }
        UserShow user = template.queryForObject(sql, new BeanPropertyRowMapper<UserShow>(UserShow.class), id);
        return user;
    }

    @Override
    public void deleteById(int id,int num) {
        String sql = "delete from score where uid = ? and pid = ?";
        template.update(sql,id,num);
    }

    @Override
    public void addUserToNewUser(int id ,int num) {
        String sql = "INSERT INTO goodUser VALUES (NULL,?,?);";
        template.update(sql,id,num);
    }


}
