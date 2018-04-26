package mitroshin.task3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class DataBaseAPI {
    private SessionFactory sessionFactory;

    DataBaseAPI() {
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void connect() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudentToDB(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

    public Student getStudentBySurname(String surname) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Student where surname = :surname")
                .setParameter("surname", surname);

        List result = query.getResultList();
        session.getTransaction().commit();
        session.close();

        if (result.isEmpty()) {
            return null;
        } else {
            return (Student) result.get(0);
        }
    }

    public void close() {
        sessionFactory.close();
    }

    public boolean deleteStudent(String surname) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("delete Student where surname = :surname")
                .setParameter("surname", surname);

        boolean result = query.executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();

        return result;
    }

    public void updateStudentScore(String surname, int i) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("update Student set score = :newScore where surname = :surname")
                .setParameter("newScore", i)
                .setParameter("surname", surname);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}

