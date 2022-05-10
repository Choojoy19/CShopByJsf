package sc.task.cshop.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sc.task.cshop.config.ConfigSessionFactory;
import sc.task.cshop.dao.BaseDao;
import sc.task.cshop.models.Coffee;

import java.util.List;
import java.util.stream.Collectors;

public class CoffeeImpl implements BaseDao<Coffee> {
    @Override
    public List<Coffee> findAll() {
        Session session = ConfigSessionFactory.getSessionFactory().openSession();

        return (List<Coffee>) session.createQuery("from Coffee").stream().collect(Collectors.toList());
    }

    @Override
    public Coffee findById(Long id) {
        Session session = ConfigSessionFactory.getSessionFactory().openSession();
        return session.get(Coffee.class, id);
    }

    @Override
    public boolean create(Coffee entity) {
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
    public Coffee update(Coffee entity) {
        Transaction transaction = null;
        try (Session session = ConfigSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
            return session.get(Coffee.class, entity.getId());
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
            Coffee coffee = session.get(Coffee.class, id);
            if (coffee != null) {
                session.delete(coffee);
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
