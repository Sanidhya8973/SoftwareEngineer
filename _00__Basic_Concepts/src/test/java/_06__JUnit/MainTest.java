package _06__JUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest implements MainInterfaceTest {

    @Test
    void test1() {
        System.out.println("the default behavior of @Test annotated method is success");
    }

    @Test
    void test2() {
        Assertions.fail("the default behavior of @Test annotated method is success");
    }

    @Test
    public void test3() {
        Main m = new Main();
        String expectedResult = "avaj";
        String actualResult = m.reverse("java");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    protected void test4() {
        Main m = new Main();
        String expectedResult = "avaJ";
        String actualResult = m.reverse("java");
        Assertions.assertEquals(expectedResult, actualResult);
    }

}
