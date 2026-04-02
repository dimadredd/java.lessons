package school.sorokin.springcore.hibernateCore.hibernateBasics.task;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        открыть SessionFactory и Session
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "school.sorokin.springcore.hibernateCore.hibernateBasics.task"
                );

//        начать транзакцию
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        Session session = sessionFactory.openSession();

//        создать и сохранить как минимум три фильма
        Movie movie1 = new Movie("arr", "horror", 2020);
        Movie movie2 = new Movie("gentlemen", "action", 2023);
        Movie movie3 = new Movie("law", "documental", 2025);

//        закоммитить транзакцию
        session.beginTransaction();
        session.persist(movie1);
        session.persist(movie2);
        session.persist(movie3);
        session.getTransaction().commit();

//        открыть новую сессию и прочитать все фильмы, вывести их в консоль
        List<Movie> movies = session.createQuery(
                "select m from Movie m", Movie.class).list();
        System.out.println("\nAll movie list:");
        movies.forEach(System.out::println);

//        выполнить JPQL‑запрос на выборку по жанру, вывести результаты
        List<Movie> genreMovies = session.createQuery(
                "select m from Movie m where m.genre = :genre", Movie.class)
                .setParameter("genre", "horror")
                .getResultList();
        System.out.println("\nHorror movies:");
        genreMovies.forEach(System.out::println);

//        начать новую транзакцию и обновить название фильма по ID, закоммитить изменения
        session.beginTransaction();
        Movie updateMovie = session.find(Movie.class, 1L);
        updateMovie.setTitle("Hello");
        session.getTransaction().commit();


//        начать ещё одну транзакцию и удалить фильм по ID, закоммитить
        session.beginTransaction();
        Movie movieToRemove = session.find(Movie.class, 2L);
        session.remove(movieToRemove);
        session.getTransaction().commit();

//        вывести в консоль список всех оставшихся фильмов
        List<Movie> updatedMovieList = session.createQuery(
                "select m from Movie m", Movie.class).list();
        System.out.println("\nUpdated movie list:");
        updatedMovieList.forEach(System.out::println);
    }
}
