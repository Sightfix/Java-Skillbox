import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import test.Detail;
import test.Employee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            Scanner in = new Scanner(System.in);
            Employee employee = new Employee(in.nextLine(),in.nextLine(),in.nextLine(),in.nextInt());
            Scanner data = new Scanner(System.in);
            Detail detail = new Detail(data.nextLine(),data.nextLine(),data.nextLine());
            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.beginTransaction();
            session.save(detail);
            Scanner id = new Scanner(System.in);
            Detail detail1 = session.get(Detail.class, id.nextInt());
            System.out.println(detail1.getEmployee());
            Scanner num = new Scanner(System.in);
            Detail detail2 = session.get(Detail.class, num.nextInt());
            detail2.getEmployee().setEmpDetail(null);
            session.delete(detail2);
            session.getTransaction().commit();
            System.out.println("DONE!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}