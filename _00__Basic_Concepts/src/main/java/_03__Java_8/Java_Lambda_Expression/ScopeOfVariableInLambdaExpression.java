package _03__Java_8.Java_Lambda_Expression;

public class ScopeOfVariableInLambdaExpression {

    int sum = 0;

    public void addition() {
        int temp = 0;
        LambdaExpression4 le = (str, a, b) -> {
            int sum = 0;
            // temp = 69; // compilation error
            this.sum = a + b; // "this" keyword refers to those variables that are outside the lambda expression (scope = global)
            System.out.println(str + ": " + sum);
            return this.sum;
        };
        System.out.println("addition: " + le.magic("addition", 5, 11));
    }

    public static void main(String[] args) {
        ScopeOfVariableInLambdaExpression eg = new ScopeOfVariableInLambdaExpression();
        eg.addition();
        // output:-
        // 0
        // 11
    }

}