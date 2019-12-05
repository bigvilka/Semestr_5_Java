package vladis.web.dao;

import vladis.web.entities.LoginPassword;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;
import vladis.web.SessionFactoryUtil;



public class DAOLoginPassword {

    private SessionFactory sessionFactory;

    public DAOLoginPassword() {
        this.sessionFactory = SessionFactoryUtil.getSessionFactory();
    }

    public boolean addLoginPassword(String login, String password) {
        boolean isOk = true;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LoginPassword lp = new LoginPassword(login, password);
        try {
            session.save(lp);
            transaction.commit();
        }
        catch (HibernateException e) {
            isOk = false;
        }
        finally {
            session.close();
        }
        return isOk;
    }

    public boolean isContainLoginPassword(String login, String password) {
        boolean isContain = false;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        LoginPassword lp2 = session.get(LoginPassword.class, login);
        if (lp2 != null) {
            if (lp2.getPassword().equals(password)) {
                isContain = true;
            }
        }
        session.close();
        return isContain;
    }

    public boolean isContainLogin(String login) {
        boolean isContain = false;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        LoginPassword lp2 = session.get(LoginPassword.class, login);
        if (lp2 != null) {
                isContain = true;
        }
        session.close();
        return isContain;
    }

    public List<LoginPassword> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<LoginPassword> lps = (List<LoginPassword>) session.createQuery("From LoginPassword").list();
        session.close();
        return lps;
    }
}
