package cn.web.servlet;

import cn.domain.User;
import cn.service.impl.UserServiceImpl;
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

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //封装User
        Map<String, String[]> map = req.getParameterMap();
        User user = null;
        try {
            user = new User();
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

//        System.out.println(user.getUsername()+"----"+user.getPassword());

        String yzm = (String) req.getSession().getAttribute("yzm");
        String htmlYzm = req.getParameter("yzm");
        //校验验证码
        if (htmlYzm.equalsIgnoreCase(yzm)){
            //查询
            UserServiceImpl userService = new UserServiceImpl();
            User user1 = userService.findUserByUP(user);
            //校验账号
            if (user1 != null){
                if (user1.getStatus().equals('Y')){
                    //*存储用户信息，登录操作界面
                    HttpSession session = req.getSession();
                    session.setAttribute("user",user1);
                    resp.sendRedirect(req.getContextPath()+"/userdowhat.jsp");
                }else {
                    //转发返回并显示错误信息
//            System.out.println("用户名或密码有误");
                    req.setAttribute("error","您有违规操作，账号已被封禁");
                    req.getRequestDispatcher("/userLogin.jsp").forward(req,resp);
                }

            }else {
                //转发返回并显示错误信息
//            System.out.println("用户名或密码有误");
                req.setAttribute("error","用户名或密码错误");
                req.getRequestDispatcher("/userLogin.jsp").forward(req,resp);
            }
        }else {
            //转发返回并显示错误信息
//            System.out.println("用户名或密码有误");
            req.setAttribute("error","验证码错误");
            req.getRequestDispatcher("/userLogin.jsp").forward(req,resp);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
