package cn.web.servlet;

import cn.domain.Quest;
import cn.domain.User;
import cn.service.impl.QuestServiceImpl;
import cn.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/getTextServlet")
public class GetTextServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String id = req.getParameter("id");
        QuestServiceImpl service = new QuestServiceImpl();
        List<Quest> text = null;
        switch (id){
            case "1":
                text = service.getText(1);
                req.getSession().setAttribute("pId",1);
                break;
            case "2":
                text = service.getText(2);
                req.getSession().setAttribute("pId",2);
                break;
            case "3":
                text = service.getText(3);
                req.getSession().setAttribute("pId",3);
        }
        req.getSession().setAttribute("text",text);
        resp.sendRedirect(req.getContextPath()+"/text.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
