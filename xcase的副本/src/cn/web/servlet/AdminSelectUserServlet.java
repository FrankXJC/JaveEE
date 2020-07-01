package cn.web.servlet;

import cn.domain.PageBean;
import cn.domain.UserShow;
import cn.service.AdminService;
import cn.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 后续查询
 */
@WebServlet("/adminSelectUserServlet")
public class AdminSelectUserServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断登录状态
        if (req.getSession().getAttribute("admin")==null){
            resp.sendRedirect(req.getContextPath()+"/adminLogin.jsp");
        }

        String currentPage = req.getParameter("currentPage");//当前页码
        String rows = req.getParameter("rows");//每页显示条数
        int num = (int) req.getSession().getAttribute("id");

        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }

        if(rows == null || "".equals(rows)){
            rows = "5";
        }



        //获取条件查询参数
        String start = req.getParameter("start");
        String over = req.getParameter("over");
        String by = req.getParameter("by");
        if(start == null || "".equals(start)){
            start = "0";
        }

        if(over == null || "".equals(over)){
            over = "100";
        }

        if(by == null || "".equals(by)){
            by = "notDo";
        }

        //2.调用service查询

        AdminService service = new AdminServiceImpl();
        PageBean<UserShow> pb = service.findUserByPage(currentPage,rows,start,over,by,  num);

        List<UserShow> list = pb.getList();
        System.out.println("pb长度--->"+list.size());

        //3.将PageBean存入request
        req.setAttribute("pb",pb);
        req.setAttribute("start",start);
        req.setAttribute("over",over);//将查询条件存入request
        //4.转发到list.jsp
        req.getRequestDispatcher("/usershow.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
