package cn.dao;


import cn.domain.Admin;
import cn.domain.Quest;
import cn.domain.User;
import cn.domain.UserShow;

import java.util.List;

public interface AdminDao {

    /**
     * 查询管理员信账号密码是否真确
     * @return
     */
    public boolean select(Admin admin);

    /**
     * 查询所有面试者信息
     * @return
     */
    public List<UserShow> findAll(int num);

    /**
     * 区间查找
     * @param a
     * @param b
     * @return
     */
    public List<UserShow> selectA_B(int a,int  b,int num);


    /**
     * 查询zongshu暂时不用
     * @return
     * @param start
     * @param over
     */
    int findTotalCount(int start,int over,int num);

    /**
     * 分页查询每页记录
     * @param currentPage
     * @param rows
     * @param genderOver
     * @param genderStart
     * @return
     */
    List<UserShow> findByPage(int currentPage, int rows,  int genderStart,int genderOver,String by,int num);

    /**
     * 根据他的查询
     * @param id
     * @return
     */
    UserShow selectById(int id,int num);

    /**
     * 根据id删除
     */
    void deleteById(int id,int num);

    /**
     * 添加成员的新表
     * @param id,num
     */
    void addUserToNewUser(int id ,int num);


}

