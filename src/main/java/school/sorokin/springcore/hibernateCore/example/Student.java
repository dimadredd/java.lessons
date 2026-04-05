package school.sorokin.springcore.hibernateCore.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Column(name = "student_name", unique = true, nullable = false)
    private String name;

    @Setter
    @Column(name = "student_age")
    private Integer age;

    @OneToOne(mappedBy = "student", cascade = CascadeType.REMOVE)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Student(
            String name,
            Integer age,
            Group group
    ) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
