package _02__Assignment.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {"_02__Assignment.model.beans", "_02__Assignment.model.implementation", "_02__Assignment.services"})
public class ProjectConfig {

}
