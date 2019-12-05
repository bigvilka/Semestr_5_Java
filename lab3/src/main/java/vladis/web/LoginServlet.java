package vladis.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import vladis.web.dao.*;
import vladis.web.dao.DAOLoginHash;
import vladis.web.dao.DAOLoginPassword;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // в это место попадаем только если у пользователя нет cookies
        // тогда нам надо проверить его login-password в БД
        String login = (String) request.getParameter("login");
        String password = (String) request.getParameter("password");
        password = DigestUtils.md5Hex(password);

        DAOLoginPassword daoLPas = new DAOLoginPassword();
        boolean isContain = daoLPas.isContainLoginPassword(login, password);

        if (isContain) {
            String uuid = UUID.randomUUID().toString();

            DAOLoginHash daoLHash = new DAOLoginHash();
            isContain = daoLHash.updateLoginHash(login, uuid);

            if(isContain){
                Cookie cookie = new Cookie("sessionId", uuid);
                response.addCookie(cookie);
            }

            if(!isContain) {
                boolean isAdd = daoLHash.addLoginHash(login, uuid);
                if (isAdd) {
                    Cookie cookie = new Cookie("sessionId", uuid);
                    response.addCookie(cookie);
                }
            }
            request.getRequestDispatcher("registered_users.jsp").forward(request, response);
        }
        else{
            String incorrectLoginPassword = "Incorrect login and password";
            response.getWriter().println(incorrectLoginPassword);
        }

    }

}
