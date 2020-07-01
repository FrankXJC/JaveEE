package cn.web.servlet;

import cn.domain.Admin;
import cn.domain.User;
import cn.service.impl.AdminServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //封装User
        Map<String, String[]> map = req.getParameterMap();
        Admin admin = null;
        try {
            admin = new Admin();
            BeanUtils.populate(admin,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(admin);

        Boolean f = new AdminServiceImpl().select(admin);
        if (f){
            //*存储用户信息，登录操作界面
            System.out.println("1");
            HttpSession session = req.getSession();
            session.setAttribute("admin",admin.getA_name());
            resp.sendRedirect(req.getContextPath()+"/admindowhat.jsp");
        }else {
            System.out.println(3);
            req.setAttribute("error","用户名或密码错误");
            req.getRequestDispatcher("/adminLogin.jsp").forward(req,resp);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
