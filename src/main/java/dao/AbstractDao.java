package dao;

import db.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

abstract public class AbstractDao<T> {

    final Class<T> type;

    public AbstractDao(Class<T> type) {
        this.type = type;
    }

    public abstract T newInstance();

    protected T newInstance(T object) {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(object);
            tx.commit();
            return object;
        }
    }

    public void update(T object) {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(object);
            tx.commit();
        }
    }

    public T get(int id) {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            return session.get(type, id);
        }
    }

    public List<T> getAll() {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(type);
            criteria.from(type);
            return session.createQuery(criteria).getResultList();
        }
    }
}
