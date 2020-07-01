package cn.service.impl;

import cn.dao.UserDao;
import cn.dao.impl.UserDaoImpl;
import cn.domain.Admin;
import cn.dao.AdminDao;
import cn.dao.impl.AdminDaoImpl;
import cn.domain.PageBean;
import cn.domain.UserShow;
import cn.service.AdminService;
import cn.domain.User;

import java.util.List;



public class AdminServiceImpl implements AdminService {
    @Override
    public Boolean select(Admin admin) {
        AdminDao adminDao = new AdminDaoImpl();
        return adminDao.select(admin);
    }

    @Override
    public List<UserShow> findAll(int num) {
        return new AdminDaoImpl().findAll(num);
    }

    @Override
    public List<UserShow> selectA_B(int a, int b,int num) {
        return new AdminDaoImpl().selectA_B(a,b,num);
    }


    @Override
    public PageBean<UserShow> findUserByPage(String _currentPage, String _rows, String _start,String _over,String by,int num) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        int start = Integer.parseInt(_start);
        int over = Integer.parseInt(_over);
        if(currentPage <=0) {
            currentPage = 1;
        }
        //1.创建空的PageBean对象
        PageBean<UserShow> pb = new PageBean<UserShow>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.调用dao查询总记录数
        AdminDaoImpl adminDao = new AdminDaoImpl();
        int totalCount = adminDao.findTotalCount(start,over,num);
        pb.setTotalCount(totalCount);
        //4.调用dao查询List集合
        //计算开始的记录索引
        int current = (currentPage - 1) * rows;
        List<UserShow> list = adminDao.findByPage(current,rows,start,over,by,num);
        pb.setList(list);

        //5.计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);


        return pb;
    }

    @Override
    public void transferUser(String _id ,int num) {
        int id = Integer.parseInt(_id);
        System.out.println("id--->"+id);
        AdminDaoImpl adminDao = new AdminDaoImpl();
        adminDao.deleteById(id,num);
        adminDao.addUserToNewUser(id,num);

    }

    @Override
    public void addUserToBlack(int id) {
        new UserDaoImpl().addUserToBlack(id);
    }

    @Override
    public List<User> getBlack() {

        return new UserDaoImpl().findBlackUser();
    }


}
