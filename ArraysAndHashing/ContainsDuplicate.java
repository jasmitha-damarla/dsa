package ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ContainsDuplicate {

    // Using StreamAPI
    public boolean hasDuplicate(int[] arr, int n){   
        return IntStream.of(arr).distinct().count() != n;
    }

    // Using Set
    public boolean containsDuplicate(int[] arr, int n){
        Set<Integer> set = new HashSet<>();
        for(int num : arr){
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.hasDuplicate(arr, n));
        System.out.println(containsDuplicate.containsDuplicate(arr, n));
    }
    
}
