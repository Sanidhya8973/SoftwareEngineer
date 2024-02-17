package _06__JUnit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.function.*;

public class MainTest implements MainTestInterface {

    private Main main;
    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeAll
    static void beforeAll() {
        System.out.println("\nTesting: started");
    }

    @BeforeEach
    void enable(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        main = new Main();
        System.out.println("\nstatus: object created");
        System.out.println("[ @TestInfo ]");
        System.out.println("TestClass   : " + testInfo.getClass());
        System.out.println("DisplayName : " + testInfo.getDisplayName());
        System.out.println("TestClass   : " + testInfo.getTestClass());
        System.out.println("TestMethod  : " + testInfo.getTestMethod());
        testReporter.publishEntry("x");
    }

    @AfterEach
    void disable() {
        main = null;
        System.out.println("status: object destroyed");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("\nTesting: ended");
    }

    @Override
    @Test
    public void test_0() {
        MainTestInterface.super.test_0();
    }

    @Test
    @Disabled
    @DisplayName("test method is in development")
    public void test_1() {
        Assertions.fail("the default behavior of @Test annotated method is success");
    }

    @Test
    @EnabledOnOs(value = {OS.WINDOWS, OS.LINUX})
    @EnabledOnJre(value = {JRE.JAVA_8, JRE.JAVA_17,})
    @DisabledOnOs(value = {OS.MAC})
    @DisabledOnJre(value = {JRE.JAVA_9, JRE.JAVA_21})
    protected void test_2() {
        System.out.println("status: running on WINDOWS/LINUX");
        if (OS.WINDOWS.toString().equals("WINDOWS")) {
            System.out.println("OS: windows");
        } else if (OS.LINUX.toString().equals("LINUX")) {
            System.out.println("OS: linux");
        }
    }

    @Test
    @DisplayName("string <-> gnirts")
    protected void test_3() {
        String expectedResult = "avaj";
        String actualResutl = main.reverse("java");
        Assertions.assertEquals(expectedResult, actualResutl, () -> "test failed: message");
    }

    @RepeatedTest(name = "repeat-test", value = 5)
    protected void test_4(RepetitionInfo ri) {
        System.out.println(ri.getCurrentRepetition());
        System.out.println(ri.getTotalRepetitions());
        System.out.println(ri.getFailureCount());
        System.out.println(ri.getFailureThreshold());
    }

    @Test
    protected void test_5() {
        Assertions.assertAll("all Executable are true",
                () -> Assertions.assertEquals(1, 2 / 2, () -> "test failed: message divide"),
                () -> Assertions.assertEquals(4, 2 * 2, () -> "test failed: message multiply"),
                () -> Assertions.assertEquals(5, 2 + 3, () -> "test failed: message add"),
                () -> Assertions.assertEquals(0, 2 - 2, () -> "test failed: message subtract")
        );
    }

    @Test
    protected void test_6() {
        Assertions.assertThrows(ArithmeticException.class, () -> main.getException(), () -> "test failed: message");
    }

    @Test
    protected void test_7() {
        Assumptions.assumeTrue(true, "assumption is correct: ture");
        Assumptions.assumeFalse(false, "assumption is correct: false");
    }

    @Test
    protected void test_8() {
        Assumptions.assumeTrue(false, "assumption is not correct: false");
        Assumptions.assumeFalse(true, "assumption is not correct: true");
    }

    @Nested
    class DMAS {

        @Test
        public void test_1() {
            Assertions.assertEquals(1, 2 / 2, () -> "test failed: message divide");
        }

        @Test
        public void test_2() {
            Assertions.assertEquals(4, 2 * 2, () -> "test failed: message multiply");
        }

        @Test
        public void test_3() {
            Assertions.assertEquals(5, 2 + 3, () -> "test failed: message add");
        }

        @Test
        public void test_4() {
            Assertions.assertEquals(0, 2 - 2, () -> "test failed: message subtract");
        }

    }

}