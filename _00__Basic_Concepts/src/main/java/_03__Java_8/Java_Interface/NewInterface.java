package _03__Java_8.Java_Interface;

public interface NewInterface {

    // method - 1
    public abstract void method1();

    public default void method2() {
        // default business logic
    }

    public static void method3() {
        // static business logic
    }

    // method - 2
    void method4();

    default void method5() {
        // default business logic
    }

    static void method6() {
        // static business logic
    }

}
