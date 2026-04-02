package school.sorokin.springcore.hibernateCore.hibernateBasics.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("school.sorokin.springcore.hibernateCore.hibernateBasics");

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        Session session = sessionFactory.openSession();

        Student student1 = new Student("vasja", 22);
        Student student2 = new Student("pasha", 20);

        session.beginTransaction();
        session.persist(student1);
        session.persist(student2);
        session.getTransaction().commit();

        Student studentById1 = session.find(Student.class, 1L);
        System.out.println("student 1:" + studentById1.toString());

        Student studentById2 = session.createQuery(
                        "SELECT s from Student s where s.id = :id", Student.class)
                .setParameter("id", 2)
                .getSingleResult();

        System.out.println("student 2:" + studentById2.toString());

        session.beginTransaction();
        Student studentForUpdate = session.find(Student.class, 1L);
        studentForUpdate.setAge(30);
        studentForUpdate.setName("Dima");
        session.getTransaction().commit();

//        session.beginTransaction();
//        Student studentForDelete = session.find(Student.class, 2L);
//        session.remove(studentForDelete);

//        session.createQuery("DELETE FROM Student s where  s.id = 2")
//                        .executeUpdate();

//        session.createNativeQuery(
//                        "delete from students s where s.id = 2")
//                .executeUpdate();

//        session.getTransaction().commit();

        List<Student> allStudents = session
                .createQuery("select s from Student s", Student.class)
                .list();

        Student studentByName = session.createQuery(
                        "SELECT s from Student s where s.name = :name", Student.class)
                .setParameter("name", "pasha")
                .getSingleResult();

        System.out.println("student by name: " + studentByName.toString());

//        session.beginTransaction();
//        Student student3 = new Student("pasha", 20);
//        session.persist(student3);
//        session.getTransaction().commit();

        session.close();
    }

}
