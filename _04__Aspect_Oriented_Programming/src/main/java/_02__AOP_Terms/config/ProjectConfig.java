package _02__AOP_Terms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(
        basePackages = {
                "_02__AOP_Terms.model.aspects",
                "_02__AOP_Terms.model.beans",
                "_02__AOP_Terms.model.implementation",
                "_02__AOP_Terms.services"
        }
)
public class ProjectConfig {

}