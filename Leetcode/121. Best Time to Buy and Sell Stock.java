class Solution { 
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0; // buy
        int right = 1; // sell

        while(right < prices.length){
            // check if it is a profitable transaction
            if(prices[left] < prices[right]){
                // calculate profit
                // update by putting maximum profit 
                profit = Math.max(profit, prices[right] - prices[left]);
            } else{
                // because in between the time period there would be no potential profit to put left in place of right
                left = right;
            }
            // increment right to check further possibilities
            right++;
        }
        // return calculated maximum profit
        return profit;
    }
}
