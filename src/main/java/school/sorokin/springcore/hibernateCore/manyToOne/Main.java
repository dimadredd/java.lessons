package school.sorokin.springcore.hibernateCore.manyToOne;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import school.sorokin.springcore.hibernateCore.manyToOne.service.PostService;
import school.sorokin.springcore.hibernateCore.manyToOne.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("school.sorokin.springcore.hibernateCore.manyToOne");

        UserService userService = context.getBean(UserService.class);
        PostService postService = context.getBean(PostService.class);

        User user1 = new User("Dima");
        User user2 = new User("Karina");
        User user3 = new User("Ivan");

        Post post1 = new Post("Hello", user1);
        Post post2 = new Post("World", user2);
        Post post3 = new Post("Bye", user1);
        Post post4 = new Post("Get", user3);
        Post post5 = new Post("Hi", user2);
        Post post6 = new Post("Lover", user1);

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);

        postService.savePost(post1);
        postService.savePost(post2);
        postService.savePost(post3);
        postService.savePost(post4);
        postService.savePost(post5);
        postService.savePost(post6);

        postService.getAllPosts()
                .forEach(System.out::println);





    }
}
