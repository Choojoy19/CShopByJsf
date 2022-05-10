package sc.task.cshop.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sc.task.cshop.config.ConfigSessionFactory;
import sc.task.cshop.dao.BaseDao;
import sc.task.cshop.models.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderImpl implements BaseDao<Order> {
    @Override
    public List<Order> findAll() {
        Session session = ConfigSessionFactory.getSessionFactory().openSession();

        return (List<Order>) session.createQuery("from Order ").stream().collect(Collectors.toList());
    }

    @Override
    public Order findById(Long id) {
        Session session = ConfigSessionFactory.getSessionFactory().openSession();
        return session.get(Order.class, id);
    }

    @Override
    public boolean create(Order entity) {
        Transaction transaction = null;
        try (Session session = ConfigSessionFactory.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public Order update(Order entity) {
        Transaction transaction = null;
        try (Session session = ConfigSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
            return session.get(Order.class, entity.getId());
        } catch (Exception exc) {
            if (transaction != null) {
                transaction.rollback();
            }

        }
        return entity;
    }

    @Override
    public boolean deleteById(Long id) {
        Transaction transaction = null;
        try (Session session = ConfigSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Order order = session.get(Order.class, id);
            if (order != null) {
                session.delete(order);
                transaction.commit();
                //session.close();
                return true;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return false;
    }
}
