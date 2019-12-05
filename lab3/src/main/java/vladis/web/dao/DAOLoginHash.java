package vladis.web.dao;

import vladis.web.entities.LoginHash;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vladis.web.SessionFactoryUtil;
import java.util.List;


public class DAOLoginHash {

    private SessionFactory sessionFactory;

    public DAOLoginHash() {
        this.sessionFactory = SessionFactoryUtil.getSessionFactory();
    }

    public boolean addLoginHash(String login, String hash) {
        boolean isOk = true;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LoginHash lh = new LoginHash(login, hash);
        try {
            session.save(lh);
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

    public boolean updateLoginHash(String login, String hash){
        boolean isContain = false;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        LoginHash lh = session.get(LoginHash.class, login);
        if (lh != null) {
            lh.setHash(hash);
            isContain = true;
            transaction.commit();
        }
        session.close();
        return isContain;

    }

    public boolean isContainLoginHash(String login, String hash) {
        boolean isContain = false;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        LoginHash lh = session.get(LoginHash.class, login);
        if (lh != null) {
            if (lh.getHash().equals(hash)) {
                isContain = true;
            }
        }
        session.close();
        return isContain;
    }

    public boolean isHashContainInTable(String hash) {
        boolean isContain = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<LoginHash> lhs = (List<LoginHash>) session.createQuery("From LoginHash").list();
        for (LoginHash lh : lhs) {
            if (lh.getHash().equals(hash)){
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    public List<LoginHash> getLogins() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<LoginHash> lhs = (List<LoginHash>) session.createQuery("From LoginHash").list();
        return lhs;
    }

}
