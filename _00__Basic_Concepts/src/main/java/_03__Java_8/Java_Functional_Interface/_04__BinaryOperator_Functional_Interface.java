package _03__Java_8.Java_Functional_Interface;

import java.util.function.BinaryOperator;

public class _04__BinaryOperator_Functional_Interface {

    public static void main(String[] args) {

        BinaryOperator<Integer> level = (a, b) -> (a > b) ? 1 : (a < b) ? -1 : 0;

        // R apply(T t)
        System.out.println("INDEX--------|");
        System.out.println("| +1 : a > b |");
        System.out.println("| -1 : a < b |");
        System.out.println("|  0 : a = b |");
        System.out.println("|-------------");
        System.out.println(level.apply(1, 2));

        // static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator)
        BinaryOperator<Integer> max = BinaryOperator.maxBy((a, b) -> (a > b) ? 1 : ((a < b) ? -1 : 0));
        System.out.println(max.apply(2, 1));
        System.out.println(max.apply(1, 2));

        // static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator)
        BinaryOperator<Integer> min = BinaryOperator.minBy((a, b) -> (a > b) ? 1 : ((a < b) ? -1 : 0));
        System.out.println(min.apply(2, 1));
        System.out.println(min.apply(1, 2));

    }

}

/*

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> BinaryOperator Functional Interface
-----------------------------------------------------------------------------------------------------------------------------------------------------------
- Binary Operator Functional Interface handles the scenarios where the datatype of 2 input parameters and 1 output parameter is the same,
  then instead of using BiFunction<T,U,R>, we can use the BinaryOperator<T>.
- BinaryOperator<T> is a child of BiFunction<T,U,R>.
- In addition to the methods that it inherits from BiFunction<T,U,R>, it also has 2 utility static methods inside it.
- They both will be used to identify the minimum or maximum of 2 elements based on the comparator logic that we pass.

  BinaryOperator<T>
  @param <T> the type of the operands and result of the operator
-----------------------------------------------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Methods available in Predicate Functional Interface
-----------------------------------------------------------------------------------------------------------------------------------------------------------
1) R apply(T t)
   - single abstract method available

2) static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator)
   - it is used to identify the minimum of 2 elements based on the comparator logic that we pass

3) static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator)
   - it is used to identify the maximum of 2 elements based on the comparator logic that we pass

4) default andThen(..)
   - default method that can be used for chaining
   - in the andThen(); the first function will be executed followed by the second function

5) default compose(..)
   - default method that can be used for chaining
   - in the compose(); it’s vice versa of andThen()
-----------------------------------------------------------------------------------------------------------------------------------------------------------

 */