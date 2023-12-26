package _04__Lazy_Instantiation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {_04__Lazy_Instantiation.beans.Person.class, _04__Lazy_Instantiation.beans.Vehicle.class})
public class ProjectConfig {

}
