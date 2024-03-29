package ru.mch.tracker.run;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.mch.tracker.entity.Item;

public class HQLUsage {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sf.openSession();
            Query query = session.createQuery("from Item");
            for (Object st : query.list()) {
                System.out.println(st);
            }
            Query<Item> query2 = session.createQuery(
                    "from Item as i where i.id = :fId", Item.class);
            query2.setParameter("fId", 396489);
            System.out.println(query2.uniqueResult());
            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}