import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "HelloInside")


public class HelloInside extends HttpServlet {

    SessionIds ids;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter pw = response.getWriter();
        pw.println("Stupid");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean allowed = false;
        Cookie[] cookie = request.getCookies();

        for (Cookie cook: cookie)
        {
            if (cook.getName() != null)
            {
                if (ids.Contains(cook.getName()))
                {
                    getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
                    allowed = true;
                    break;
                }
            }
        }

        if (allowed == false)
        {
            getServletContext().getRequestDispatcher("/start").forward(request, response);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ids = SessionIds.getInstance();
    }
}
