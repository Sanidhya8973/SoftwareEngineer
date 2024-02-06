package _03__Java_8.Java_Functional_Interface;

import java.util.function.Supplier;

public class _06__Supplier_Functional_Interface {

    public static void main(String[] args) {

        // T get()
        Supplier<String> greet = () -> {
            return "Welcome Home!";
        };
        System.out.println(greet.get());

    }

}

/*

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Supplier Functional Interface
-----------------------------------------------------------------------------------------------------------------------------------------------------------
- Supplier Functional Interface supplies/returns a value without accepting any input parameter.
- There are no static and default methods available in Supplier Functional Interface.
- The reason is that it will not accept any input so there is no meaning of chaining in it.

  Supplier<T>
  @param <T> the type of results supplied by the supplierl
-----------------------------------------------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Methods available in Supplier Functional Interface
-----------------------------------------------------------------------------------------------------------------------------------------------------------
1) T get()
   - single abstract method available
-----------------------------------------------------------------------------------------------------------------------------------------------------------

 */