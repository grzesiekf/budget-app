package db;

import model.Outgo;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {

    private static SessionFactory sessionFactory;

    public static void init() {
        if(sessionFactory != null) return;
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Outgo.class);
            configuration.addAnnotatedClass(User.class);
            sessionFactory = configuration.configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
