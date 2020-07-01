package cn.web.servlet;

import cn.domain.Quest;
import cn.service.QuestService;
import cn.service.impl.QuestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getAllTextServlet")
public class GetAllTextServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        QuestService service = new QuestServiceImpl();
        List<Quest> text = service.findAll(id);


        req.getSession().setAttribute("adminText",text);
        req.getRequestDispatcher("/dotext.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
