package _06__PostConstruct_PreDestroy_Annotations.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void initialize() {
        this.name = "FORD";
        System.out.println("\n> Initializing Bean: @PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("\n> Destroying Bean: @PreDestroy");
    }

}

// We have seen that when we are using stereotype annotations, we don't have control while creating a bean.
// But what if we want to execute some instructions post Spring creates the bean.
// So, we can use @PostConstruct annotation.
// Spring borrows the @PostConstruct annotation from JAVA EE / Jakarta EE
// import jakarta.annotation.PostConstruct;
// We can define a method in the component class and annotate that method with @PostConstruct, which instructs Spring to execute that method after it finishes creating beans.
//
// @PreDestroy annotation can be used on top of the methods and Spring will make sure to call this method just before clearing and destroying the context.
// This can be used in scenarios where we want to close any IO resources, Database connection, etc...
// Spring borrows the @PreDestroy annotation from JAVA EE / Jakarta EE
// import jakarta.annotation.PreDestroy;
