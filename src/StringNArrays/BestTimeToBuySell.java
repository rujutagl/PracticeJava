package StringNArrays;

public class BestTimeToBuySell {
    /*
    TC: O(n) SC: O(1)
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int profit = 0;
        int min = prices[0];
        int max = 0;
        for(int i : prices){
            min = Math.min(min, i);
            profit = i - min;
            max = Math.max(max, profit);
        }
        return max;
    }
    /*
    On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
    However, you can buy it then immediately sell it on the same day.
    Find and return the maximum profit you can achieve.
    Example 1:
    Input: prices = [7,1,5,3,6,4]
    Output: 7
    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
    Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
    Total profit is 4 + 3 = 7.
     */
    public int maxProfitII(int[] prices) {
        if(prices.length == 0) return 0;
        int profit = 0;
        for(int i = 0; i< prices.length-1; i++){
            if(prices[i+1] > prices[i]){
                profit+=prices[i+1] - prices[i];
            }
        }
        return profit;
    }
}
