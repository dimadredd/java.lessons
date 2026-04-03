package school.sorokin.springcore.hibernateCore.example;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import school.sorokin.springcore.hibernateCore.example.service.ProfileService;
import school.sorokin.springcore.hibernateCore.example.service.StudentService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("school.sorokin.springcore.hibernateCore.example");

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);

        StudentService service = context.getBean(StudentService.class);
        ProfileService profileService = context.getBean(ProfileService.class);

        Student student1 = new Student("vasya", 15);
        Student student2 = new Student("pasha", 27);

        service.saveStudent(student1);
        service.saveStudent(student2);

        Profile profile1 = new Profile("My bio", LocalDateTime.now(), student1);

        profileService.saveProfile(profile1);


    }
}