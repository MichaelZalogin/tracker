package ru.mch.tracker.store;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.*;
import ru.mch.tracker.entity.Item;
import java.sql.SQLException;
import static org.assertj.core.api.Assertions.*;

public class HbmTrackerTest {

    private static SessionFactory sf;

    @BeforeAll
    public static void initSessionFactory() {
        sf = new MetadataSources(new StandardServiceRegistryBuilder()
                .configure().build())
                .buildMetadata().buildSessionFactory();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        var session = sf.openSession();
        try {
            session.beginTransaction();
            var query = session.createQuery("DELETE Item");
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @AfterAll
    public static void closeSessionFactory() throws SQLException {
        sf.close();
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }
}