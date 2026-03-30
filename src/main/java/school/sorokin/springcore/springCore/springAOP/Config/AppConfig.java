package school.sorokin.springcore.springCore.springAOP.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("school.sorokin.springcore.springCore.springAOP")
@EnableAspectJAutoProxy
public class AppConfig {
}
