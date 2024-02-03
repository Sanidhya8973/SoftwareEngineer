package _03__Java_8.Java_Interface.Example_Default_Method;

public interface B {

    public default void method1() {
        System.out.println("> Interface B: default method");
    }

    public abstract void method2();

}
