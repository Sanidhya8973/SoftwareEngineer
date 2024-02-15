package _09__Spring_Stereotype_Annotations.main;

/*
Spring provides special annotations called Stereotype Annotations, which will help to create the Spring Beans automatically in the application context.

There are 4 types of Stereotype Annotations in Spring:-

    <---<--@Component-->--->
    |          |           |
    v          v           v
@Service  @Repository  @Controller

1) @Component : It is used as general on top of any JAVA class. It is the base for other annotations.
   import org.springframework.stereotype.Component;

2) @Service   : It can be used on top of the classes inside the Service Layer especially where we write business logic & make external API calls.
   import org.springframework.stereotype.Service;

3) @Repository: It can be used on top of the classes which handles the code related to Database access operations like insert, update, delete, etc...
   import org.springframework.stereotype.Repository;

4) @Controller: It can be used on top of the classes inside the Controller Layer of MVC Applications.
   import org.springframework.stereotype.Controller;

*/

public class Main {

    public static void main(String[] args) {
        printTheory();
    }

    public static void printTheory() {
        System.out.println("\n" +
                "Spring provides special annotations called Stereotype Annotations, which will help to create the Spring Beans automatically in the application context.\n" +
                "\n" +
                "There are 4 types of Stereotype Annotations in Spring:-\n" +
                "\n" +
                "    <---<--@Component-->--->\n" +
                "    |          |           |\n" +
                "    v          v           v\n" +
                "@Service  @Repository  @Controller\n" +
                "\n" +
                "1) @Component : It is used as general on top of any JAVA class. It is the base for other annotations.\n" +
                "   import org.springframework.stereotype.Component;\n" +
                "\n" +
                "2) @Service   : It can be used on top of the classes inside the Service Layer especially where we write business logic & make external API calls.\n" +
                "   import org.springframework.stereotype.Service;\n" +
                "\n" +
                "3) @Repository: It can be used on top of the classes which handles the code related to Database access operations like insert, update, delete, etc...\n" +
                "   import org.springframework.stereotype.Repository;\n" +
                "\n" +
                "4) @Controller: It can be used on top of the classes inside the Controller Layer of MVC Applications.\n" +
                "   import org.springframework.stereotype.Controller;");
    }

}