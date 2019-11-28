import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

@WebServlet(name = "CountToGetIn")
public class CountToGetIn extends HttpServlet {

    int Sum;
    Map<Integer, List<String>> answerValue;
    SessionIds ids;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String answer = request.getParameter("answer");
        String hash = request.getParameter("hash");

        if (answer.equals(String.valueOf(Sum)))
        {
            if (answerValue.containsKey(Sum))
            {
                if (answerValue.get(Sum).contains(hash))
                {
                    UUID id = UUID.randomUUID();

                    ids.Add(String.valueOf(id));

                    Cookie cookie = new Cookie(String.valueOf(id), hash);
                    response.addCookie(cookie);

                    request.getRequestDispatcher("/home").forward(request, response);
                }
            }
        }
        else
        {
            String path = request.getContextPath() + "/start";
            response.sendRedirect(path);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int number1 = -125 + (int)(Math.random()*472);
            int number2 = -125 + (int)(Math.random()*472);

            Sum = number1 + number2;

            int time = LocalTime.now().getHour() + LocalTime.now().getMinute() + LocalTime.now().getSecond();
            int hash = String.valueOf(Sum + time).hashCode();

            if(answerValue.containsKey(Sum))
            {
                answerValue.get(Sum).add(String.valueOf(hash));
            }
            else
            {
                List<String> values = new ArrayList<String>();
                values.add(String.valueOf(hash));

                answerValue.put(Sum, values);
            }

            request.setAttribute("number1", number1);
            request.setAttribute("number2", number2);
            request.setAttribute("hash", hash);

            getServletContext().getRequestDispatcher("/start.jsp").forward(request, response);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        answerValue = new HashMap<Integer, List<String>>();
        ids = SessionIds.getInstance();
    }
}
