package _06__JUnit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.function.*;

public class MainTest {

    private Main main;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Testing: started");
    }

    @BeforeEach
    void enable() {
        main = new Main();
        System.out.println("status: object created");
    }

    @AfterEach
    void disable() {
        main = null;
        System.out.println("status: object destroyed");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Testing: ended");
    }

    @Test
    public void test1() {
        Assertions.fail("the default behavior of @Test annotated method is success");
    }

    @Test
    public void test2() {
        String expectedResult = "avaJ";
        String actualResutl = main.reverse("Java");
        Assertions.assertEquals(expectedResult, actualResutl, "reverse a string");
    }

    @Test
    public void test3() {
        Assertions.assertThrows(ArithmeticException.class, () -> main.getException(), "exception-thrown");
    }

}
