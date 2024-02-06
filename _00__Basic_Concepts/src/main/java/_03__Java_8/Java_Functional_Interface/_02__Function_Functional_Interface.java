package _03__Java_8.Java_Functional_Interface;

import java.util.function.Function;

public class _02__Function_Functional_Interface {

    public static void main(String[] args) {

        Function<Integer, Integer> entry = (value) -> {
            System.out.println("entry is good");
            return value;
        };

        Function<Integer, Integer> exit = (value) -> {
            System.out.println("exit is casual");
            return value + 1;
        };

        Function<String, Integer> count = (str) -> {
            int c = 0;
            for (int i = 0; i < str.length(); i++) {
                c++;
            }
            return c;
        };

        // R apply(T t)
        System.out.println(exit.apply(1));
        System.out.println(entry.apply(1));
        System.out.println(count.apply("abcd"));

        // static <T> Function<T,T> identity()
        Function<String, String> object = Function.identity();
        System.out.println(object.apply("xyz"));

        // default andThen(..)
        System.out.println(entry.andThen(exit).apply(1));

        // default compose(..)
        System.out.println(entry.compose(exit).apply(1));

    }

}

/*

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Function Functional Interface
-----------------------------------------------------------------------------------------------------------------------------------------------------------
- Function Functional Interface handles the scenarios where we accept an input parameter of any type and return the any datatype after processing the input.

  Function<T,R> object;
  @param <T> the type of the input to the function
  @param <R> the type of the result of the function
-----------------------------------------------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Methods available in Function Functional Interface
-----------------------------------------------------------------------------------------------------------------------------------------------------------
1) R apply(T t)
   - single abstract method available

2) static <T> Function<T,T> identity()
   - Utility static method which will return the same input value as the output

3) default compose(..)/andThen(..)
   - default method that can be used for chaining
-----------------------------------------------------------------------------------------------------------------------------------------------------------

 */