package com.aleksandrphilimonov.hibernate_one_to_many_bi;

import com.aleksandrphilimonov.hibernate_one_to_many_bi.entity.Department;
import com.aleksandrphilimonov.hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee1 = new Employee("Aleh", "Perepelkin", 540);
//            Employee employee2 = new Employee("Igor", "Vladov", 1020);
//            Employee employee3 = new Employee("Illa", "Boton", 1200);
//
//            Department department = new Department("SALE", 1500, 300);
//            session.save(department);
//            department.addEmployeeToDepartment(employee2);
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee3);

            System.out.println("get department\n------------------------------------------------------------------------------------------------------");
            Department department = session.get(Department.class, 8);
            System.out.println("show department\n------------------------------------------------------------------------------------------------------");
            System.out.println(department);


            session.getTransaction().commit();
            System.out.println("show employees of the department\n------------------------------------------------------------------------------------------------------");
            System.out.println(department.getEmps());
            System.out.println("DONE!\n------------------------------------------------------------------------------------------------------");
        } finally {
            session.close();
            factory.close();
        }
    }
}
