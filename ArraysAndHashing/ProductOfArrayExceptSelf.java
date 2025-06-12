package ArraysAndHashing;

import java.util.Scanner;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums, int N) {
        int[] res = new int[N];
        res[0]=1;
        for(int i = 1; i < N; i++){
            res[i] = res[i - 1]*nums[i - 1];
        }
        int suffix = 1;
        for(int i = N - 1; i >= 0; i--){
            res[i] *= suffix;
            suffix *= nums[i];
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        for(int num : productOfArrayExceptSelf.productExceptSelf(arr, n)){
            System.out.println(num);
        }
    }
}
