package school.sorokin.springcore.hibernateCore.oneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_profiles")
@Getter
@NoArgsConstructor
@Component

public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bio")
    @Setter
    private String bio;

    @Column(name = "last_time_seen")
    @Setter
    private LocalDateTime lastTimeSeen;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Setter
    private User user;

    public UserProfile(String bio, LocalDateTime lastTimeSeen, User user) {
        this.bio = bio;
        this.lastTimeSeen = lastTimeSeen;
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", lastTimeSeen=" + lastTimeSeen +
                '}';
    }
}
