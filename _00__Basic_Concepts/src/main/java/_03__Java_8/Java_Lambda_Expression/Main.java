package _03__Java_8.Java_Lambda_Expression;

public class Main {

    public static void main(String[] args) {

        // when we have only one line of code
        LambdaExpression1 le = () -> System.out.println("hello world!");
        // when lambda expression has no return type
        le.magic();
        // when lambda expression has a return type
        // System.out.println(le.magic());

        // method - 1
        // no parameter
        LambdaExpression1 le1 = () -> {
            // business logic
        };
        // return type
        LambdaExpression2 le2 = () -> {
            return "business logic: ";
        };
        // with parameters
        LambdaExpression3 le3 = (String str, int a, int b) -> {
            // business logic
        };

        // method - 2
        // no parameter
        LambdaExpression1 le4 = () -> {
            // business logic
        };
        // with parameters
        LambdaExpression3 le5 = (str, a, b) -> {
            // business logic
        };

    }

}