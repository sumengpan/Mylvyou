package com.smp.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CharchaterFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse rep, FilterChain filterChain) throws IOException, ServletException {

        req.setCharacterEncoding("utf-8");
        // 处理响应乱码
        rep.setContentType("text/html;charset=utf-8");
        // 放行请求
        filterChain.doFilter(req,rep);
    }

    public void destroy() {

    }
}

