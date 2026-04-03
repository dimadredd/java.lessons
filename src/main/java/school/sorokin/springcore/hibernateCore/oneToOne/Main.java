package school.sorokin.springcore.hibernateCore.oneToOne;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import school.sorokin.springcore.hibernateCore.oneToOne.service.ProfileService;
import school.sorokin.springcore.hibernateCore.oneToOne.service.UserService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("school.sorokin.springcore.hibernateCore.oneToOne");

        UserService userService = context.getBean(UserService.class);
        ProfileService profileService = context.getBean(ProfileService.class);

        User user1 = new User("Paul");
        User user2 = new User("Dima");
        UserProfile profile1 = new UserProfile("paul", LocalDateTime.now(), user1);
        UserProfile profile2 = new UserProfile("dima", LocalDateTime.now(), user2);

        userService.saveUser(user1);
        userService.saveUser(user2);
        profileService.saveProfile(profile1);
        profileService.saveProfile(profile2);

        profileService.printUserProfileById(1L);
        userService.printUserById(2L);

        profileService.deleteProfile(1L);
        userService.deleteUser(1L);
    }
}
