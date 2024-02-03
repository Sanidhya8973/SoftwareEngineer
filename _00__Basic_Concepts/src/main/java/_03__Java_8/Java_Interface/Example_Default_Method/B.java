package _03__Java_8.Java_Interface.Example_Default_Method;

public interface B {

    public default String method1() {
        return "> Interface B: default method";
    }

    public abstract void method2();

}
