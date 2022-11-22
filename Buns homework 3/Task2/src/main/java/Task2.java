import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import test.entity.Department;
import test.entity.Employee;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();

            Scanner data = new Scanner(System.in);
            Department department = new Department(data.nextLine(),data.nextInt(), data.nextInt());

            Scanner emp = new Scanner(System.in);
            Employee employee = new Employee(emp.nextLine(),emp.nextLine(), emp.nextInt());

            Scanner emp1 = new Scanner(System.in);
            Employee employee1 = new Employee(emp1.nextLine(),emp1.nextLine(), emp1.nextInt());

            Scanner emp2 = new Scanner(System.in);
            Employee employee2 = new Employee(emp2.nextLine(),emp2.nextLine(),emp2.nextInt());

            department.addEmployeeToDepartment(employee);
            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);

            session.beginTransaction();

            Scanner id = new Scanner(System.in);
            Employee findEmployee = session.get(Employee.class, id.nextInt());
            System.out.println(findEmployee);
            System.out.println(findEmployee.getDepartment());

            Scanner iD = new Scanner(System.in);
            Employee removeEmployee = session.get(Employee.class, iD.nextInt());
            session.delete(removeEmployee);

            session.persist(department);
            session.getTransaction().commit();
            System.out.println("DONE!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}