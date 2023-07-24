package com.aleksandrphilimonov.hibernate_many_to_many;

import com.aleksandrphilimonov.hibernate_many_to_many.entity.Child;
import com.aleksandrphilimonov.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = factory.getCurrentSession();

            Section section1 = new Section("Footbal");
            Child child1 = new Child("Aleks", 4);
            Child child2 = new Child("Misha", 5);
            Child child3 = new Child("Nadya", 6);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();

            session.save(section1);

            session.getTransaction().commit();
            System.out.println("DONE!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
