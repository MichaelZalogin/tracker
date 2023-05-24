package ru.mch.tracker.store;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.*;
import ru.mch.tracker.entity.Item;
import java.sql.SQLException;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

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
    public void whenAddNewItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenDeleteItem() {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item("item1");
            tracker.add(item1);
            assertThat(tracker.delete(item1.getId())).isTrue();
            assertThat(tracker.delete(item1.getId())).isFalse();
            assertThat(tracker.findById(item1.getId())).isNull();
        }
    }

    @Test
    public void whenSaveItemAndFindAll() {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item("item1");
            Item item2 = new Item("item2");
            Item item3 = new Item("item3");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            List<Item> expected = List.of(item1, item2, item3);
            assertThat(tracker.findAll()).isEqualTo(expected);
        }
    }

    @Test
    public void whenReplaceItem() {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item("item1");
            tracker.add(item1);
            int id = item1.getId();
            item1.setName("Edit name");
            tracker.replace(id, item1);
            assertThat(tracker.findById(id).getName()).isEqualTo("Edit name");
        }
    }

    @Test
    public void whenFindByName() {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item("item1");
            Item item2 = new Item("item2");
            Item item3 = new Item("item3");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            List<Item> expected = List.of(item1, item2, item3);
            List<Item> result = tracker.findByName("tem");
            assertThat(result).contains(item1, item2, item3);
        }
    }

}