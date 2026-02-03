package ArraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TopKElements {

    public int[] getTopKElements(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num :  arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer>[] frequency = new List[arr.length + 1];
        for(int i = 0; i < frequency.length; i++){
            frequency[i] = new ArrayList<>();
        }
        for(Integer key : map.keySet()){
            frequency[map.get(key)].add(key);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = frequency.length - 1; i > 0 && index < k; i--) {
            for (int n : frequency[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
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
        int k = scanner.nextInt();
        TopKElements topKElements = new TopKElements();
        for(int num : topKElements.getTopKElements(arr, k)){
            System.out.println(num);
        }
    }
    
}
