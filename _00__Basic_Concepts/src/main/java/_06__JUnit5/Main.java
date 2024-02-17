package _06__JUnit5;

public class Main {

    public String reverse(String str) {
        char[] arr = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return new String(arr);
    }

    public ArithmeticException getException() {
        throw new ArithmeticException();
    }

}
