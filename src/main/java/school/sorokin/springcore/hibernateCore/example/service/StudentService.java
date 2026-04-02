package school.sorokin.springcore.hibernateCore.example.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import school.sorokin.springcore.hibernateCore.example.Student;

import java.util.List;

@Service
public class StudentService {

    private final SessionFactory sessionFactory;

    public StudentService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Student saveStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    public void deleteStudent(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student studentForDelete = session.find(Student.class, id);
        session.remove(studentForDelete);
        session.close();
    }

    public Student getById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.find(Student.class, id);
        session.close();
        return student;
    }

    public List<Student> findAll() {
        Session session = sessionFactory.openSession();
        List<Student> allStudents = session
                .createQuery("select s from Student s", Student.class)
                .list();
        session.close();
        return allStudents;
    }

    public Student updateStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        student = session.merge(student);
        session.close();
        return student;
    }
}
