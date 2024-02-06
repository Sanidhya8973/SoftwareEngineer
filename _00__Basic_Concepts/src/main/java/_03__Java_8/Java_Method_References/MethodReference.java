package _03__Java_8.Java_Method_References;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class MethodReference {

    public static String add(int a, int b) {
        return "> Addition: " + (a + b);
    }

    public String sum(int a, int b) {
        return "> Addition: " + (a + b);
    }

    public static void main(String[] args) {

        // these techniques are mainly used with custom @FunctionalInterface to eliminate code duplication
        BiFunction<Integer, Integer, String> test = (a, b) -> {
            return "> Addition: " + (a + b);
        };
        System.out.println(test.apply(1, 1));

        // Class::staticMethod -> static method reference
        BiFunction<Integer, Integer, String> test1 = MethodReference::add;
        System.out.println(test1.apply(1, 2));

        // objRef::instanceMethod -> a reference to an instance method from an instance (object.method())
        MethodReference mr = new MethodReference();
        BiFunction<Integer, Integer, String> test2 = mr::sum;
        System.out.println(test2.apply(1, 3));

        // Class::instanceMethod -> a reference to an instance method from a class type (Class.method())
        List<Character> test3 = Arrays.asList('a', 'b', 'c', 'd');
        test3.forEach(c -> System.out.println(c));
        test3.forEach(System.out::println);

        // Class::new -> constructor reference
        BiFunction<String, Integer, User> test4 = User::new;
        User user = test4.apply("name", 1);
        System.out.println(user.getName());
        System.out.println(user.getId());

    }

}

/*

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Method Reference
-----------------------------------------------------------------------------------------------------------------------------------------------------------
- Sometimes, there is already a method that carries out exactly the actions that we would like to pass on inside lambda code.
- In such cases, it would be nicer to pass on the method instead of duplicating the code again.
- This problem is solved using method references in Java 8.
- Method References are a special type of lambda expressions that are often used to create simple lambda expressions by referencing existing methods.
- Method References are used in Lambda Expressions to reuse the existing methods instead of writing the lambda expression with the same business logic from scratch.
- Java has introduced a new operator :: (double colon) called Method Reference Delimiter.
- In general, one does not have to pass arguments to method references.
-----------------------------------------------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> There Are 4 Types Of Method References Introduced In Java 8
-----------------------------------------------------------------------------------------------------------------------------------------------------------
1) (Class::staticMethod)    - static method reference
2) (objRef::instanceMethod) - a reference to an instance method from an instance (object.method())
3) (Class::instanceMethod)  - a reference to an instance method from a class type (Class.method())
4) (Class::new)             - constructor reference
-----------------------------------------------------------------------------------------------------------------------------------------------------------

 */