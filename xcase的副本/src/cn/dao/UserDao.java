package cn.dao;

import cn.domain.Quest;
import cn.domain.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {

    /**
     * 根据账号密码查询用户
     * @return
     */
    public User findUserByUP(User user);



    /**
     * 将User添加到服务器的方法
     */
    public void saveUser(User user);


    /**
     * 添加用户到黑名单
     * @param id
     */
    void addUserToBlack(int id);


    /**
     * 查询黑名单用户
     * @return
     */
    List<User> findBlackUser();
}
