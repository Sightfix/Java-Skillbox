import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import test.entity.Child;
import test.entity.Section;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class Task3 {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
              session = factory.getCurrentSession();

              Scanner unit = new Scanner(System.in);
              Section section = new Section(unit.nextLine());

              Scanner unit1 = new Scanner(System.in);
              Section section1 = new Section(unit1.nextLine());

              Scanner unit2 = new Scanner(System.in);
              Section section3 = new Section(unit2.nextLine());

              Scanner baby = new Scanner(System.in);
              Child child = new Child(baby.nextLine(),baby.nextInt());

              Scanner baby1 = new Scanner(System.in);
              Child child1 = new Child(baby1.nextLine(),baby1.nextInt());

              Scanner baby3 = new Scanner(System.in);
              Child child3 = new Child(baby3.nextLine(),baby3.nextInt());

              child.addSectionToChild(section);
              child1.addSectionToChild(section1);
              child3.addSectionToChild(section3);

              session.beginTransaction();

              session.persist(child);
              session.persist(child1);
              session.persist(child3);

              System.out.println("Поиска по секции введите id секции");
              Scanner find = new Scanner(System.in);
              int iD = find.nextInt();
              Section findSection = session.get(Section.class, iD);
              System.out.println(findSection);
              System.out.println(findSection.getChildren());

              System.out.println("Поиска по детям введите id ребенка");
              Scanner search = new Scanner(System.in);
              int ID = search.nextInt();
              Child searchChild = session.get(Child.class, ID);
              System.out.println(searchChild);
              System.out.println(searchChild.getSections());

              System.out.println("Для удлаения секции введите id секции");
              Scanner find1 = new Scanner(System.in);
              int iD1 = find1.nextInt();
              Section deleteSection = session.get(Section.class, iD1);
              session.delete(deleteSection);
              System.out.println("Секция удален");

              System.out.println("Для удаления ребенка введите id ребенка");
              Scanner search1 = new Scanner(System.in);
              int ID1 = search1.nextInt();
              Child deleteChild = session.get(Child.class, ID1);
              session.delete(deleteChild);
              System.out.println("Ребенок удален");

              session.getTransaction().commit();
              System.out.println("DONE!!!");

         }
        finally {
            session.close();
            factory.close();
        }
        }
    }

