package cn.web.servlet;

import cn.domain.Quest;
import cn.domain.Score;
import cn.domain.User;
import cn.service.impl.QuestServiceImpl;
import cn.service.impl.ScoreServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/textInsertServlet")
public class TextInsertServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        /*  判断试题答案  */
        //获取试题
        List<Quest> text = (List<Quest>) req.getSession().getAttribute("text");
        Integer pId = (Integer) req.getSession().getAttribute("pId");
        //获取用户答案
        Map<String, String[]> map = req.getParameterMap();


        //改卷获取分数
        Integer s = new QuestServiceImpl().getScore(text, map);

        /*  写入分数将用户数据存储到服务器  */
        Score score = new Score(user.getUid(),pId,s);
        System.out.println(score);
        ScoreServiceImpl scoreService = new ScoreServiceImpl();
        scoreService.saveScore(score);

        resp.sendRedirect(req.getContextPath()+"/textOver.jsp");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
