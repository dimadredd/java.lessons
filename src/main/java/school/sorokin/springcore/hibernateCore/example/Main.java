package school.sorokin.springcore.hibernateCore.example;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import school.sorokin.springcore.hibernateCore.example.service.GroupService;
import school.sorokin.springcore.hibernateCore.example.service.ProfileService;
import school.sorokin.springcore.hibernateCore.example.service.StudentService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("school.sorokin.springcore.hibernateCore.example");

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);

        StudentService service = context.getBean(StudentService.class);
        ProfileService profileService = context.getBean(ProfileService.class);
        GroupService groupService = context.getBean(GroupService.class);

        Group group1 = groupService.saveGroup("1", 2024L);
        Group group2 = groupService.saveGroup("2", 2024L);
        Group group3 = groupService.saveGroup("3", 2024L);

        Student student1 = new Student("vasya", 15, group1);
        Student student2 = new Student("pasha", 27, group1);

        service.saveStudent(student1);
        service.saveStudent(student2);

        System.out.println("------------");
        groupService.findAll();




    }
}