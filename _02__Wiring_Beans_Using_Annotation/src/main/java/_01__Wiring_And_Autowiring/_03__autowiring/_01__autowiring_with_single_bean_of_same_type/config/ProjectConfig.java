package _01__Wiring_And_Autowiring._03__autowiring._01__autowiring_with_single_bean_of_same_type.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "_01__Wiring_And_Autowiring._03__autowiring.beans.autowired_required_true.using_field")
public class ProjectConfig {

}
