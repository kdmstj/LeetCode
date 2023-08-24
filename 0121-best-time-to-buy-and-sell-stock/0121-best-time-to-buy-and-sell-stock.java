class Solution {
    public int maxProfit(int[] prices) {
     
        int min = prices[0];
        int max = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            int price = prices[i];
            if(price < min){
                min = price;
                max = price;
            }else if(price > max){
                max = price;
            }
            
            profit = max - min > profit ? max-min : profit;
        }
        
        return profit;
    }
}