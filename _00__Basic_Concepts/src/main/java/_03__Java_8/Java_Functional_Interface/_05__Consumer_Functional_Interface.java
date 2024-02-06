package _03__Java_8.Java_Functional_Interface;

import java.util.function.Consumer;

public class _05__Consumer_Functional_Interface {

    public static void main(String[] args) {

        // R accept(T t)
        Consumer<String> count = (str) -> {
            int c = 0;
            for (int i = 0; i < str.length(); i++) {
                c++;
            }
            System.out.println(c);
        };
        count.accept("abcd");

        // default andThen(..)
        Consumer<String> print = count.andThen((str) -> {
                    System.out.println(str);
                }
        );
        print.accept("abcd");
        print.andThen(count).accept("abcd");

    }

}
/*

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Consumer Functional Interface
-----------------------------------------------------------------------------------------------------------------------------------------------------------
- Consumer Functional Interface consumes/accepts the given input for processing but not returning anything to the invocation method.
- No static methods are available in Consumer Functional Interface.

  Consumer<T>
  @param <T> the type of the input to the function
-----------------------------------------------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Methods available in Consumer Functional Interface
-----------------------------------------------------------------------------------------------------------------------------------------------------------
1) void accept(T t)
   - single abstract method available

2) default andThen(..)
   - default method that can be used for chaining
   - in the andThen(); the first function will be executed followed by the second function
-----------------------------------------------------------------------------------------------------------------------------------------------------------

 */