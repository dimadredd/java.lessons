package school.sorokin.springcore.hibernateCore.oneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "users")
@Component
@Getter
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    @Setter
    private String name;

    @OneToOne(mappedBy = "user")
    @Setter
    private UserProfile userProfile;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
