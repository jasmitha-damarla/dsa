package SlidingWindow;

import java.util.Scanner;

public class BuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0, i = 0, j = 1, N = prices.length;
        while(j < N) {
            while(i < N - 1 && j < N && prices[i] >= prices[j]){
                i++;
                j++;
            } while(i < N - 1 && j < N && prices[i] < prices[j]) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                j++;
            }
            i = j;
            j = i + 1;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        BuyAndSellStock buyAndSellStock = new BuyAndSellStock();
        System.out.println(buyAndSellStock.maxProfit(arr));
    }
    
}
