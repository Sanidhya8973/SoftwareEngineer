package _03__Eager_Instantiation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "_03__Eager_Instantiation.beans")
public class ProjectConfig {

}
