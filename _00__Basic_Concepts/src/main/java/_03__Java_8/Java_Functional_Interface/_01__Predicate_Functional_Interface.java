package _03__Java_8.Java_Functional_Interface;

import java.util.function.Predicate;

public class _01__Predicate_Functional_Interface {

    public static void main(String[] args) {

        Predicate<Integer> isEven = i -> i % 2 == 0;
        Predicate<Integer> isOdd = i -> i % 2 == 1;

        // boolean test(T t)
        System.out.println("> Is Even: " + isEven.test(69));
        System.out.println("> Is Odd : " + isOdd.test(69));

        // default Predicate<T> negate()
        System.out.println("> Is Not Even: " + isEven.negate().test(69));
        System.out.println("> Is Not Odd : " + isOdd.negate().test(69));

        // static <T> Predicate<T> isEqual(Object targetObj)
        // it is case-sensitive
        Predicate<String> checkEquality = Predicate.isEqual("java");
        System.out.println("> Check Equality: " + checkEquality.test("java")); // true
        System.out.println("> Check Equality: " + checkEquality.test("JAVA")); // false

        // default Predicate<T> and(Predicate<? super T> other)
        // _ & _ : both must be true
        // true = 1, false = 0 : [1&1]->1, [0&0]->0, [1&0]->0, [0&1]->0
        int n = 88;
        Predicate<Integer> isMoreThan = x -> x > n;
        Predicate<Integer> isLessThan = x -> x < n;
        System.out.println("> Is 'x' Even Number AND Greater Than 'n' ? [" + isMoreThan.and(isEven).test(69) + "]");
        System.out.println("> Is 'x' Even Number AND Smaller Than 'n' ? [" + isLessThan.and(isEven).test(69) + "]");
        System.out.println("> Is 'x' Odd Number AND Greater Than 'n' ? [" + isMoreThan.and(isOdd).test(69) + "]");
        System.out.println("> Is 'x' Odd Number AND Smaller Than 'n' ? [" + isLessThan.and(isOdd).test(69) + "]");

        // default Predicate<T> or(Predicate<? super T> other)
        // _ || _ : either of them, one must be true
        // true = 1, false = 0 : [1||1]->1, [0||0]->0, [1||0]->1, [0||1]->1
        System.out.println("> Is 'x' Even Number OR Greater Than 'n' ? [" + isMoreThan.or(isEven).test(69) + "]");
        System.out.println("> Is 'x' Even Number OR Smaller Than 'n' ? [" + isLessThan.or(isEven).test(69) + "]");
        System.out.println("> Is 'x' Odd Number OR Greater Than 'n' ? [" + isMoreThan.or(isOdd).test(69) + "]");
        System.out.println("> Is 'x' Odd Number OR Smaller Than 'n' ? [" + isLessThan.or(isOdd).test(69) + "]");

    }

}

/*

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Predicate Functional Interface
-----------------------------------------------------------------------------------------------------------------------------------------------------------
- Predicate Functional Interface handles the scenarios where we accept an input parameter and return the boolean after processing the input.

  Predicate<T> object;
  @param <T> the type of the input to the function
-----------------------------------------------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Methods available in Predicate Functional Interface
-----------------------------------------------------------------------------------------------------------------------------------------------------------
1) boolean test(T t)
   - single abstract method available.

2) static <T> Predicate<T> isEqual(Object targetObj)
   - static method to check the equality of 2 objects.

3) default Predicate<T> and(Predicate<? super T> other)
   - default method that can be used while joining multiple predicate conditions.
   - this acts like a logical AND condition.

4) default Predicate<T> or(Predicate<? super T> other)
   - default method that can be used while joining multiple predicate conditions.
   - this acts like a logical OR condition.

5) static Predicate<T> not(Predicate<? super T> other)

6) default Predicate<T> negate()
   - default method that can be used while joining multiple predicate conditions.
   - this acts like a logical NOT condition.
-----------------------------------------------------------------------------------------------------------------------------------------------------------

 */