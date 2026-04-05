package school.sorokin.springcore.hibernateCore.manyToOne.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import school.sorokin.springcore.hibernateCore.manyToOne.User;
import school.sorokin.springcore.hibernateCore.manyToOne.config.TransactionConfig;

@Service
public class UserService {

    private final SessionFactory sessionFactory;
    private final TransactionConfig transactionService;

    public UserService(
            SessionFactory sessionFactory,
            TransactionConfig transactionService
    ) {
        this.sessionFactory = sessionFactory;
        this.transactionService = transactionService;
    }

    public User saveUser(User user) {
        return transactionService.executeInTransaction(session -> {
            session.persist(user);
            return user;
        });
    }

    public User getUserById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(User.class, id);
        }
    }

    public void deleteStudent(Long id) {
        transactionService.executeInTransaction(session -> {
            var userToDelete = session.find(User.class, id);
            session.remove(userToDelete);
        });
    }
}
