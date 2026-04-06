class Solution {
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        int min = prices[0];

        for(int price : prices){
            int profit = price - min;
            min = Math.min(min, price);
            maxPro = Math.max(maxPro, profit);
        }
        return maxPro;
    }
}
