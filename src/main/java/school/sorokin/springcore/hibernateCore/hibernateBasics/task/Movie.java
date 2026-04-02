package school.sorokin.springcore.hibernateCore.hibernateBasics.task;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "movies")
@Getter
@NoArgsConstructor
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "movie_title", nullable = false)
    @Setter
    private String title;

    @Column(name = "movie_genre", nullable = false)
    @Setter
    private String genre;

    @Column(name = "release_year")
    @Setter
    private int releaseYear;

    public Movie(String title, String genre, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
}
