package school.sorokin.springcore.hibernateCore.hibernateBasics.task.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import school.sorokin.springcore.hibernateCore.hibernateBasics.task.Movie;

import java.util.List;

@Service
public class MovieService {

    private final SessionFactory sessionFactory;


    public MovieService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//      закоммитить транзакцию
    public Movie saveMovie(Movie movie) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(movie);
        session.getTransaction().commit();
        session.close();
        return movie;
    }

//    открыть новую сессию и прочитать все фильмы
    public List<Movie> showAllMovies() {
        Session session = sessionFactory.openSession();
        List<Movie> movies = session
                .createQuery("select m from Movie m", Movie.class)
                .list();
        session.close();
        return movies;
    }

    public List<Movie> findMoviesByGenre(String genre) {
        Session session = sessionFactory.openSession();
        List<Movie> genreMovies = session
                .createQuery("select m from Movie m where m.genre = :genre", Movie.class)
                .setParameter("genre", genre)
                .getResultList();
        session.close();
        return genreMovies;
    }

    public Movie updateMovieTitleById(Long id, String title){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Movie movie = session.find(Movie.class, id);
        movie.setTitle(title);
        session.getTransaction().commit();
        session.close();
        return movie;
    }

    public void deleteMovieById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Movie movie = session.find(Movie.class, id);
        session.remove(movie);
        session.getTransaction().commit();
        session.close();
    }



}
