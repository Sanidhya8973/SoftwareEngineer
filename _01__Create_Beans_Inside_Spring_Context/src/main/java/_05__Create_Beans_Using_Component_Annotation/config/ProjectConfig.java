package _05__Create_Beans_Using_Component_Annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"_05__Create_Beans_Using_Component_Annotation.beans"})                  // METHOD-1
@ComponentScan(basePackageClasses = _05__Create_Beans_Using_Component_Annotation.beans.Vehicle.class)  // METHOD-2
public class ProjectConfig {

}
// @Component is one of the most commonly used stereotype annotation by developers.
// Using this we can easily create and add a bean to the Spring Context by writing less code compared to the @Bean annotation.
// With Stereotype annotations, we need to add the annotation above the class for which we need to have an instance in the Spring Context.
// Using @ComponentScan() annotation over the configuration class, instructs Spring on where to find the classes you marked with stereotype annotations.
// There are 2 ways to use @ComponentScan() annotation...
// 1) @ComponentScan( basePackages = { "com.company.beans", "com.company.services", ... } )
//    Examples:-
//    @ComponentScan( basePackages = "com.sanidhya.beans" )
//    @ComponentScan( basePackages = { "com.sanidhya.beans", "com.sanidhya.services", } )
// 2) @ComponentScan( basePackageClasses = { com.company.beans.MyClass.class, com.company.services.MyServices.class, ... } )
//    Examples:-
//    @ComponentScan( basePackageClasses = com.sanidhya.beans.Brand.class )
//    @ComponentScan( basePackageClasses = { com.sanidhya.beans.Vehicle.class, com.sanidhya.beans.Person.class } )