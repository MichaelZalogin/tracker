package ru.mch.tracker.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;
import ru.mch.tracker.entity.Item;

public class HbmTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        var session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        var session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            var query = session.createQuery("""
                            UPDATE Item
                            SET name = :fname
                            WHERE id = :fId
                                    """)
                    .setParameter("name", item.getName())
                    .setParameter("id", id);
            result = query.executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        var session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            var query = session.createQuery("""
                            DELETE Item
                            WHERE id = :fId
                                    """)
                    .setParameter("id", id);
            result = query.executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        var session = sf.openSession();
        List<Item> itemList = new ArrayList<>();
        try {
            session.beginTransaction();
            Query<Item> query = session.createQuery("FROM Item");
            itemList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return itemList;
    }

    @Override
    public List<Item> findByName(String key) {
        var session = sf.openSession();
        List<Item> itemList = new ArrayList<>();
        try {
            session.beginTransaction();
            Query<Item> query = session.createQuery("""
                            FROM Item
                            WHERE name LIKE :fkey
                            """)
                    .setParameter("key", "%" + key + "%");
            itemList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return itemList;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Item item = null;
        try {
            Query<Item> query = session.createQuery("""
                            FROM Item
                            WHERE id = :fId
                            """)
                    .setParameter("fId", id);
            item = query.uniqueResult();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}