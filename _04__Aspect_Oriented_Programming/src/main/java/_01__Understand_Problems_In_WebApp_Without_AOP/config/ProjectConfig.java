package _01__Understand_Problems_In_WebApp_Without_AOP.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(
        basePackages = {
                "_01__Understand_Problems_In_WebApp_Without_AOP.model.beans",
                "_01__Understand_Problems_In_WebApp_Without_AOP.model.implementation",
                "_01__Understand_Problems_In_WebApp_Without_AOP.services"
        }
)
public class ProjectConfig {

}
