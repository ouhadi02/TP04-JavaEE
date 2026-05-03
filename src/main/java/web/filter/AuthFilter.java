package web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest  req  = (HttpServletRequest)  request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI(); 
        if (uri.endsWith("/login") || uri.endsWith("/logout")) {
            
        	chain.doFilter(request, response);
            return;   
        }
        HttpSession session = req.getSession(false);
        boolean connecte = (session != null && session.getAttribute("utilisateur") != null);

        if (connecte) {
        	
            chain.doFilter(request, response);            
        } else {
        	
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    } 
    @Override
    public void destroy() {}
}