package school.sorokin.springcore.springCore.property;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application1.properties")
@ComponentScan("school.sorokin.springcore.springCore.property")
public class AppConfig {
}
