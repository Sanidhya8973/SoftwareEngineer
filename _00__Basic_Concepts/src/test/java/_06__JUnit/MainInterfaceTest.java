package _06__JUnit;

import org.junit.jupiter.api.Test;

public interface MainInterfaceTest {

    @Test
    public default void test5() {
        System.out.println("Visibility of @Test annotation method can be public, protected and default (only available in interface).");
    }

}
