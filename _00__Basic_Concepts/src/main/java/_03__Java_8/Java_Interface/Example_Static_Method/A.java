package _03__Java_8.Java_Interface.Example_Static_Method;

public interface A {

    public static void method() {
        System.out.println("> Interface A: static method");
    }

    public static void main(String[] args) {
        // since Java 8, static methods are allowed, so we can write a main method inside an interface and execute it as well
    }

}
