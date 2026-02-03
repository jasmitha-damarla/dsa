package recursion;

import java.util.Scanner;

public class PrintNameNTimes {

    private void printName(String name, int count, int N) {
        if (count == N) {
            return;
        }
        printName(name, count + 1, N);
        System.out.println(name);
    }

    public static void main(String[] args) {
        PrintNameNTimes printNameNTimes = new PrintNameNTimes();
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        int N = scan.nextInt();
        printNameNTimes.printName(name, 0, N);
    }
}