package hibernate_test_2.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Detail detail = session.get(Detail.class, 10);

            System.out.println(detail.getEmployee());
            session.beginTransaction();


            session.getTransaction().commit();
            System.out.println("DONE!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
