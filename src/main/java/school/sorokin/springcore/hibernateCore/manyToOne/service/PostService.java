package school.sorokin.springcore.hibernateCore.manyToOne.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import school.sorokin.springcore.hibernateCore.manyToOne.Post;
import school.sorokin.springcore.hibernateCore.manyToOne.config.TransactionConfig;

import java.util.List;

@Service
public class PostService {

    public final SessionFactory sessionFactory;
    public final TransactionConfig transactionService;
    private final UserService userService;


    public PostService(
            SessionFactory sessionFactory,
            TransactionConfig transactionService, UserService userService
    ) {
        this.sessionFactory = sessionFactory;
        this.transactionService = transactionService;
        this.userService = userService;
    }

    public Post savePost(
            Post post
    ) {
        return transactionService.executeInTransaction(session -> {
            session.persist(post);
            return post;
        });
    }

    public List<Post> getAllPosts() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                    "SELECT p FROM Post p JOIN FETCH p.author", Post.class)
                    .getResultList();
        }
    }


}
