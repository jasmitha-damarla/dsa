package TwoPointer;

import java.util.Scanner;

public class TwoIntegerSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] sol = new int[2];
        int l = 0, r = numbers.length - 1;
        while(l < r){
            int sum = numbers[l] + numbers[r];
            if(sum == target) {
                sol[0] = l + 1;
                sol[1] = r + 1;
                return sol;
            } else if(sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        TwoIntegerSum twoIntegerSum = new TwoIntegerSum();
        System.out.println(twoIntegerSum.twoSum(arr, k));
    }
    
}
