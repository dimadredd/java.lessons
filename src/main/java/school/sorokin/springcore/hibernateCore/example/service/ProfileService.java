package school.sorokin.springcore.hibernateCore.example.service;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import school.sorokin.springcore.hibernateCore.example.Profile;
import school.sorokin.springcore.hibernateCore.example.TransactionHelper;

@Service
public class ProfileService {

    private final SessionFactory sessionFactory;
    private final TransactionHelper transactionHelper;


    public ProfileService(SessionFactory sessionFactory, TransactionHelper transactionHelper) {
        this.sessionFactory = sessionFactory;
        this.transactionHelper = transactionHelper;
    }

    public Profile saveProfile(Profile profile) {
        return transactionHelper.executeInTransaction(session -> {
            session.persist(profile);
            return profile;
        });
    }


}
