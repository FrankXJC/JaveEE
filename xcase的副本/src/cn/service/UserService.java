package cn.service;

import cn.domain.Quest;
import cn.domain.User;

import java.util.ArrayList;
import java.util.Map;

public interface UserService {

    /**
     * 根据账号密码查询用户
     * @return
     */
    public User findUserByUP(User user);



    /**
     * 将User添加到服务器的方法
     */
    public void saveUser(User user);
}
