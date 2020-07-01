package cn.web.servlet;

import cn.dao.impl.UserDaoImpl;
import cn.service.AdminService;
import cn.service.impl.AdminServiceImpl;
import com.sun.org.apache.xpath.internal.functions.FuncId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addBlackServlet")
public class AddBlackServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取id
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        new UserDaoImpl().addUserToBlack(id);
        //3.跳转到查询所有Servlet
        resp.sendRedirect(req.getContextPath()+"/adminSelectUserServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
