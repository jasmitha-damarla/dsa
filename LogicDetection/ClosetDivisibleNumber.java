import java.util.Scanner;

public class ClosetDivisibleNumber {

    public int getClosetDivisible(int n, int m){
        int q = n/m;
        int n1 = m*q;
        int n2 = (n*m)>0 ? m*(q+1) : m*(q-1);
        return Math.abs(n1-n)<Math.abs(n2-n)?n1:n2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ClosetDivisibleNumber obj = new ClosetDivisibleNumber();
        System.out.println(obj.getClosetDivisible(n, m));

    }
}
