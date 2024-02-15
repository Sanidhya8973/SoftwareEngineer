package _15__Lazy_Instantiation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {_15__Lazy_Instantiation.beans.Person.class, _15__Lazy_Instantiation.beans.Vehicle.class})
public class ProjectConfig {

}
