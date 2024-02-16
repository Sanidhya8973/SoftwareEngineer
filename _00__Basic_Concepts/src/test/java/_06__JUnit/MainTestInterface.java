package _06__JUnit;

import org.junit.jupiter.api.*;

public interface MainTestInterface {
    @Test
    public default void test_0() {
        System.out.println("Visibility of @Test annotation method can be public, protected and default (only available in interface)");
    }

}
