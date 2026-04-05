package school.sorokin.springcore.hibernateCore.manyToOne.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import school.sorokin.springcore.hibernateCore.manyToOne.Post;
import school.sorokin.springcore.hibernateCore.manyToOne.User;

@org.springframework.context.annotation.Configuration
public class HibernateConfig {

    @Bean
    public SessionFactory sessionFactory() {
        Configuration configuration = new Configuration();

        configuration
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Post.class)
                .addPackage("school.sorokin.springcore.hibernateCore.manyToOne")
                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "root")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "create-drop")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return configuration.buildSessionFactory();
    }
}
