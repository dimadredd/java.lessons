package school.sorokin.springcore.hibernateCore.hibernateBasics.task;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import school.sorokin.springcore.hibernateCore.hibernateBasics.task.Service.MovieService;

public class Main {
    public static void main(String[] args) {

//        открыть SessionFactory и Session
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "school.sorokin.springcore.hibernateCore.hibernateBasics.task"
                );

        MovieService movieService = context.getBean(MovieService.class);

//        создать и сохранить как минимум три фильма
        Movie movie1 = new Movie("arr", "horror", 2020);
        Movie movie2 = new Movie("gentlemen", "action", 2023);
        Movie movie3 = new Movie("law", "documental", 2025);


//        открыть новую сессию и прочитать все фильмы, вывести их в консоль
        movieService.saveMovie(movie1);
        movieService.saveMovie(movie2);
        movieService.saveMovie(movie3);

        System.out.println("\nMovie List:");
        movieService.showAllMovies()
                .forEach(System.out::println);

//        выполнить JPQL‑запрос на выборку по жанру, вывести результаты
        System.out.println("\nHorror movie list:");
        movieService.findMoviesByGenre("horror")
                .forEach(System.out::println);


//        начать новую транзакцию и обновить название фильма по ID, закоммитить изменения
        movieService.updateMovieTitleById(3L, "Honey");


//        начать ещё одну транзакцию и удалить фильм по ID, закоммитить
        movieService.deleteMovieById(2L);


//        вывести в консоль список всех оставшихся фильмов
        System.out.println("\nMovie List:");
        movieService.showAllMovies()
                .forEach(System.out::println);

    }
}
