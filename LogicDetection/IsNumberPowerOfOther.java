import java.util.Scanner;

public class IsNumberPowerOfOther {

    public boolean isPowerOfOther(int num1, int num2) {
        double res = Math.log(num2)/Math.log(num1);
        return res == Math.floor(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a+", "+b);
        IsNumberPowerOfOther isPower = new IsNumberPowerOfOther();
        System.out.println(isPower.isPowerOfOther(a,b));
    }
}
