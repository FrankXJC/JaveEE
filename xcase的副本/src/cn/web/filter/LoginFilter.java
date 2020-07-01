package cn.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginFilter implements Filter {

    public void destroy() {
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //将接口类转化为http子类
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        String requestURI = request.getRequestURI();

        //排除包含登录确实所需要的资源，给予放行
        if (requestURI.contains("/index.jsp") || requestURI.contains("/userLoginServlet") || requestURI.contains("/loginError.jsp") || requestURI.contains("/userLoginServlet2") ){
            chain.doFilter(request,response);
        }else{
            //不包含，即验证用户是否已经登录
            if (user != null || user ==""){
                //登陆了，放行
                chain.doFilter(request,response);
            }else{
                //没有登录，跳转回登录页面
                request.setAttribute("error","请先登陆您的帐号");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
