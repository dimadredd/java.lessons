package school.sorokin.springcore.hibernateCore.oneToOne.service;

import org.springframework.stereotype.Component;
import school.sorokin.springcore.hibernateCore.oneToOne.UserProfile;
import school.sorokin.springcore.hibernateCore.oneToOne.config.TransactionHelper;

@Component
public class ProfileService {
    private final TransactionHelper transactionHelper;

    public ProfileService(TransactionHelper transactionHelper) {
        this.transactionHelper = transactionHelper;
    }

    public UserProfile saveProfile(UserProfile profile) {
        return transactionHelper.executeInTransaction(session -> {
            session.persist(profile);
            System.out.println("Profile number %s successfully created!\n"
                    .formatted(profile.getId()));
            return profile;
        });
    }

    public void printUserProfileById(Long id) {
        transactionHelper.executeInTransaction(session -> {
            UserProfile loadedProfile = session.find(UserProfile.class, id);
            System.out.println("ID: " + loadedProfile.getId()
                    + "; User name: " + loadedProfile.getUser().getName());
            System.out.println();
        });
    }

    public void deleteProfile(long id) {
        transactionHelper.executeInTransaction(session -> {
            UserProfile profile = session.find(UserProfile.class, id);
            session.remove(profile);
            System.out.println("Profile ID: %s, successfully deleted!\n"
                    .formatted(profile.getId()));
        });
    }
}
