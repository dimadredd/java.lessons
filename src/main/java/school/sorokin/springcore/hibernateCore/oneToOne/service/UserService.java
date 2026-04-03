package school.sorokin.springcore.hibernateCore.oneToOne.service;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import school.sorokin.springcore.hibernateCore.oneToOne.User;
import school.sorokin.springcore.hibernateCore.oneToOne.UserProfile;
import school.sorokin.springcore.hibernateCore.oneToOne.config.TransactionHelper;

@Component
public class UserService {
    private final SessionFactory sessionFactory;
    private final TransactionHelper transactionHelper;

    public UserService(SessionFactory sessionFactory, TransactionHelper transactionHelper) {
        this.sessionFactory = sessionFactory;
        this.transactionHelper = transactionHelper;
    }

    public User saveUser(User user) {
        return transactionHelper.executeInTransaction(session -> {
            session.persist(user);
            System.out.println("User %s, created!"
                    .formatted(user.getName()));
            return user;
        });
    }

    public void printUserById(Long id) {
        transactionHelper.executeInTransaction(session -> {
            User loadedUser = session.find(User.class, id);
            UserProfile loadedProfile = loadedUser.getUserProfile();

            if (loadedProfile != null) {
                System.out.printf("User: %s; \nProfile: %s%n",
                        loadedUser, loadedProfile);
            } else {
                System.out.println("Profile not found!");
            }
        });
    }

    public void deleteUser(Long id) {
        transactionHelper.executeInTransaction(session -> {
            User user = session.find(User.class, id);
            session.remove(user);
            System.out.println("User %s, deleted!"
                    .formatted(user.getId()));
        });
    }

}
