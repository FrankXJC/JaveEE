package cn.service.impl;

import cn.domain.Quest;
import cn.domain.User;
import cn.dao.impl.UserDaoImpl;
import cn.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    @Override
    public User findUserByUP(User user) {
        return new UserDaoImpl().findUserByUP(user);
    }







    @Override
    public void saveUser(User user) {
        new UserDaoImpl().saveUser(user);

    }
}
