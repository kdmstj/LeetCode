class Solution {
    public int maxProfit(int[] prices) {
        //1. 최댓값을 담은 dp 생성
        int[] dp = new int[prices.length];
        int index = prices.length-1;
        dp[index] = 0;
        
        //2. 상향식으로 dp 채우기 
        while(index >= 0){
            //2.1 해당하는 index를 기준으로 마지막 날까지 순회하면서 최대값 구하기
            int current = prices[index];
            for(int i = index+1 ; i < prices.length; i++){
                //만약 현재보다 값이 높은 경우 팔 수 있음 (아닐 경우 0)
                int tmp = 0;
                if(current < prices[i]){
                    tmp = prices[i] - current;
                }
                //현재 날짜 이익 이후에 최대 이익을 구한 후 더하기
                dp[index] = dp[index] > tmp + dp[i] ? dp[index] : tmp + dp[i];
            }
            index--;
        }
        return dp[0];
    }
}