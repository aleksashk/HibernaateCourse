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

            Employee employee = new Employee("Patric", "Homs", "SALE", 840);
            Detail detail = new Detail("Praga", "4578", "pack@gmail.com");

            detail.setEmployee(employee);
            session.beginTransaction();

            session.save(detail);

            session.getTransaction().commit();
            System.out.println("DONE!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
