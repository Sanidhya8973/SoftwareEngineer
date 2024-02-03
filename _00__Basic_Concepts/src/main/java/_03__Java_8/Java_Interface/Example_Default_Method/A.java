package _03__Java_8.Java_Interface.Example_Default_Method;

public interface A {

    public default String method1() {
        return "> Interface A: default method";
    }

    public abstract void method2();

}
