package school.sorokin.springcore.hibernateCore.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "student_group")
@Getter
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    @Setter
    private String number;

    @Column(name = "grad_year")
    @Setter
    private Long graduationYear;

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    @Setter
    private List<Student> studentList;

    public Group(String number, Long graduationYear) {
        this.number = number;
        this.graduationYear = graduationYear;
    }
}
