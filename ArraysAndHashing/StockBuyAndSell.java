package ArraysAndHashing;

import java.util.Arrays;

public class StockBuyAndSell {

    public int stockbuySell(int[] prices) {
        int minPrice = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - minPrice;
            profit = Math.max(profit, cost);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        StockBuyAndSell sol = new StockBuyAndSell();

        // Test case 1: LeetCode-style example
        int[] prices1 = { 7, 1, 5, 3, 6, 4 };
        System.out.println("prices1: " + Arrays.toString(prices1));
        System.out.println("Max profit: " + sol.stockbuySell(prices1)); // 5 (buy 1, sell 6)
        System.out.println();

        // Test case 2: Always decreasing (no profit)
        int[] prices2 = { 9, 7, 4, 3, 1 };
        System.out.println("prices2: " + Arrays.toString(prices2));
        System.out.println("Max profit: " + sol.stockbuySell(prices2)); // 0
        System.out.println();

        // Test case 3: Single day
        int[] prices3 = { 5 };
        System.out.println("prices3: " + Arrays.toString(prices3));
        System.out.println("Max profit: " + sol.stockbuySell(prices3)); // 0
        System.out.println();

        // Test case 4: Profit at the end
        int[] prices4 = { 5, 4, 3, 2, 10 };
        System.out.println("prices4: " + Arrays.toString(prices4));
        System.out.println("Max profit: " + sol.stockbuySell(prices4)); // 8 (buy 2, sell 10)
        System.out.println();

        // Test case 5: Multiple ups and downs
        int[] prices5 = { 3, 8, 2, 5, 1, 7 };
        System.out.println("prices5: " + Arrays.toString(prices5));
        System.out.println("Max profit: " + sol.stockbuySell(prices5)); // 6 (buy 1, sell 7)
    }
}
