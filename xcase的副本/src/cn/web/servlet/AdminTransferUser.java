package cn.web.servlet;

import cn.service.AdminService;
import cn.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminTransferUser")
public class AdminTransferUser extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取id
        String id = req.getParameter("id");
        int num = (int) req.getSession().getAttribute("id");
        //2.调用service删除
        AdminService service = new AdminServiceImpl();
        service.transferUser(id,num);

        //3.跳转到查询所有Servlet
        resp.sendRedirect(req.getContextPath()+"/adminSelectUserServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
