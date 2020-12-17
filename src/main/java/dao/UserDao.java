package dao;

import db.MySessionFactory;
import model.User;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.Query;


public class UserDao extends AbstractDao<User> {

    private static volatile UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) {
            synchronized (UserDao.class) {
                if (instance == null) {
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }

    public User getByName(String name) {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Users u where u.name = :name", User.class);
            query.setParameter("name", name);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    private UserDao() {
        super(User.class);
    }

}
