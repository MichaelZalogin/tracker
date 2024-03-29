package ru.mch.tracker.run;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.mch.tracker.entity.Item;
import java.time.LocalDateTime;

public class DateRun {
    public static void main(String[] args) {
        var registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (var sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            var session = sf.openSession();
            session.beginTransaction();
            var item = new Item();
            item.setName("check timezone3");
            item.setCreated(LocalDateTime.now());
            session.persist(item);
            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}