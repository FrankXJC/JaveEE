package cn.service;

import cn.domain.*;

import java.util.List;

/**
 * 管理员管理应聘者接口
 */
public interface AdminService {

    /**
     * 查询管理员信账号密码是否真确
     *
     * @return
     */
    public Boolean select(Admin admin);

    /**
     * 查询所有面试者信息
     *
     * @return
     */
    public List<UserShow> findAll(int num);

    /**
     * 区间查找
     *
     * @param a
     * @param b
     * @return
     */
    public List<UserShow> selectA_B(int a, int b,int num);


    /**
     * 分页查询
     *
     * @param _currentPage
     * @param _rows
     * @param _start
     * @param _over
     * @return
     */
    public PageBean<UserShow> findUserByPage(String _currentPage, String _rows, String _start, String _over, String by, int num);

    /**
     * 用户转移
     * @param id
     */
    void transferUser(String id,int num);

    /**
     * 添加用户到黑名单
     * @param id
     */
    void addUserToBlack(int id);


    /**
     * 获取黑名单
     */
    List<User> getBlack();

}
