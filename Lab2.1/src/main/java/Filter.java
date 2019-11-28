import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter
{
    private FilterConfig filterConfig;
    private SessionIds ids;;

    public void destroy()
    {
        filterConfig = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {
        if (filterConfig.getInitParameter("active").equalsIgnoreCase("true")) {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) resp;

            boolean allowed = false;
            Cookie[] cookie = request.getCookies();

            if (cookie.length == 1) {
                allowed = true;
            }

            for (Cookie cook : cookie) {
                if (ids.Contains(cook.getName())) {
                    allowed = false;
                    break;
                }
            }

            if (allowed && request.getServletPath() == "/home") {
                request.getRequestDispatcher("start").forward(req, resp);

            }
            if (!allowed){
                request.getRequestDispatcher("home").forward(req, resp);
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException
    {
        filterConfig = config;
        ids = SessionIds.getInstance();
    }

}
