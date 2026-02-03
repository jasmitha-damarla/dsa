package recursion;

public class FibnocciNumber {

    private int fibnocciNumber(int N) {
        if (N <= 1) {
            return N;
        }
        return fibnocciNumber(N - 1) + fibnocciNumber(N - 2);
    }

    public static void main(String[] args) {
        FibnocciNumber fibnocciNumber = new FibnocciNumber();
        System.out.println(fibnocciNumber.fibnocciNumber(3));
    }
}
