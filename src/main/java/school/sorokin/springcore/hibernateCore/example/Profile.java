package school.sorokin.springcore.hibernateCore.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "last_seen_time")
    private LocalDateTime lastSeenTime;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    public Profile(String bio, LocalDateTime lastSeenTime, Student student) {
        this.bio = bio;
        this.lastSeenTime = lastSeenTime;
        this.student = student;
    }
}
