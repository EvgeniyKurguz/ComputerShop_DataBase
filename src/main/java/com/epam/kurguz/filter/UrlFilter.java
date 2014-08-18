package com.epam.kurguz.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UrlFilter implements Filter {

    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        doFilter((HttpServletRequest) req, (HttpServletResponse) resp, chain);
    }

    private void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {

        String pathInfo = req.getRequestURI().substring(req.getContextPath().length());

        if (pathInfo.startsWith("/static")) {
            chain.doFilter(req, resp);
            return;
        }
        if (pathInfo.startsWith("/WEB-INF")) {
            chain.doFilter(req, resp);
            return;
        }
        req.getRequestDispatcher("/do" + pathInfo).forward(req, resp);
    }
}
