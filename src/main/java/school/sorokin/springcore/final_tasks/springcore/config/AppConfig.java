package school.sorokin.springcore.final_tasks.springcore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("school.sorokin.springcore.final_tasks.springcore")
public class AppConfig {
}
