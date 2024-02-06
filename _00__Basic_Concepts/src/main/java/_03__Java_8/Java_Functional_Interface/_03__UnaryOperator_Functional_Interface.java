package _03__Java_8.Java_Functional_Interface;

import java.util.function.UnaryOperator;

public class _03__UnaryOperator_Functional_Interface {

    public static void main(String[] args) {

        // static <T> Function<T,T> identity()
        UnaryOperator<String> object = UnaryOperator.identity();
        System.out.println(object.apply("abcd"));

        UnaryOperator<Integer> entry = (value) -> {
            System.out.println("entry is good");
            return value;
        };

        UnaryOperator<Integer> exit = (value) -> {
            System.out.println("exit is casual");
            return value + 1;
        };

        // R apply(T t)
        System.out.println(exit.apply(1));
        System.out.println(entry.apply(1));

        // default andThen(..)
        System.out.println(entry.andThen(exit).apply(1));

        // default compose(..)
        System.out.println(entry.compose(exit).apply(1));

    }

}

/*

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> UnaryOperator Functional Interface
-----------------------------------------------------------------------------------------------------------------------------------------------------------
- Unary Operator Functional Interface handles the scenarios where both the input and output parameters datatype is the same, then instead of using Function<T,R>, we can use the UnaryOperator<T>.
- It is a child of Function<T,T>. So all the methods apply(), andThen(), compose() are available inside the UnaryOperator interface also.
- In other words, we can say that the UnaryOperator interface takes one argument and returns a result of the same type of its arguments.

  UnaryOperator<T>
  @param <T> the type of the operand and result of the operator
-----------------------------------------------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Methods available in UnaryOperator Functional Interface
-----------------------------------------------------------------------------------------------------------------------------------------------------------
1) R apply(T t)
   - single abstract method available

2) static <T> Function<T,T> identity()
   - Utility static method which will return the same input value as the output

3) default andThen(..)
   - default method that can be used for chaining
   - in the andThen(); the first function will be executed followed by the second function

4) default compose(..)
   - default method that can be used for chaining
   - in the compose(); it’s vice versa of andThen()
-----------------------------------------------------------------------------------------------------------------------------------------------------------

 */