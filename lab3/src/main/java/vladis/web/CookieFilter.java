package vladis.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

import vladis.web.dao.*;
import vladis.web.dao.DAOLoginHash;


@WebFilter("/CookieFilter")
public class CookieFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        Cookie[] cookies = request.getCookies();
        //Проверка существует ли куки, по умолчанию в мозиле(?) всегда выдаются JSESSIONID
        if ((cookies != null && cookies.length != 1)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    String sessionIdHash = cookie.getValue();
                    DAOLoginHash daoLHash = new DAOLoginHash();
                    String login = (String) request.getParameter("login");
                    boolean isValid = daoLHash.isHashContainInTable(sessionIdHash);
                    if (isValid)
                        request.getRequestDispatcher("registered_users.jsp").forward(request, response);
                }
            }
        }
        else{
            if (request.getRequestURI().equals("/lab3_war_exploded/registered_users.jsp"))
                response.sendRedirect(request.getContextPath() + "/");
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
