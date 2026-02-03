package recursion;

import java.util.Scanner;

public class PrintNNumbers {

    private void printNumbersAsc(int N) {
        if (N < 1) {
            return;
        }
        printNumbersAsc(N - 1);
        System.out.println(N);
    }

    private void printNumbersDsc(int N) {
        if (N < 1) {
            return;
        }
        System.out.println(N);
        printNumbersDsc(N - 1);
    }

    public static void main(String[] args) {
        PrintNNumbers printNNumber = new PrintNNumbers();
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        System.out.println("Ascending Order:");
        printNNumber.printNumbersAsc(N);
        System.out.println("Descending Order:");
        printNNumber.printNumbersDsc(N);
    }
}
