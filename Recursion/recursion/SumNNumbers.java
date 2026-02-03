package recursion;

import java.util.Scanner;

public class SumNNumbers {

    private void sumOfNParameterized(int N, int sum) {

        if (N < 1) {
            System.out.println("Sum of N numbers Paramterized way: " + sum);
            return;
        }
        sumOfNParameterized(N - 1, sum + N);
    }

    private int sumOfNFunctional(int N) {

        if (N == 0) {
            return 0;
        }
        return N + sumOfNFunctional(N - 1);
    }

    public static void main(String[] args) {
        SumNNumbers sumNNumbers = new SumNNumbers();
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        sumNNumbers.sumOfNParameterized(N, 0);
        System.out.println("Sum of N numbers Functional way: " + sumNNumbers.sumOfNFunctional(N));
    }

}
