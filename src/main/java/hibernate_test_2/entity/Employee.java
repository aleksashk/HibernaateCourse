package hibernate_test_2.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String firstname;

    @Column(name="surname")
    private String surname;

    @Column(name="department")
    private String department;

    @Column(name="salary")
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "details_id")
    private Detail empDetail;

    public Employee() {
    }

    public Employee(String firstname, String surname, String department, int salary) {
        this.firstname = firstname;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
