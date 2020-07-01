package cn.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**  处理中文乱码的过滤器
 * @author Administrator
 */
@WebFilter("/*")
public class CharterFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //将接口类转化为http子类
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //获取请求方式
        String method = request.getMethod();
        //设置post请求方式中文编码
        if ("post".equalsIgnoreCase(method)){
            request.setCharacterEncoding("utf-8");
        }
        //设置返回头请求方式---->解决响应乱码
        response.setContentType("text/http;charset=utf-8");

        //放行
        chain.doFilter(request,response);




    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
