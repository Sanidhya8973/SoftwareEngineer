package _03__Java_8.Java_Interface.Example_Default_Method;

public class C implements A, B {

    public String method1() {
        // we have to choose what we have to return from 3 different things
        // return "> Interface C: overrides default method of A and B";
        // return A.super.method1();
        // return B.super.method1();
        return "Interface C: overrides default method of A and B";
    }

    public void method2() {
        // business logic
    }

}
