class Solution {
    public int maxProfit(int[] prices) {
        /*
            Input: int array prices
            output: int max profit obtainables from choosing a single day to buy and choosing a different
            day to sell. If there is no way to achieve any profit, return 0

            Strategy
            - Profit is achieved by buying low and selling high
            - since selling can only be done after buying, max profit seen so far equals
            the current min seen so far minus today's price.

        */
        int res = 0;
        int curr_min = prices[0];
        for (int price:prices) {
            curr_min = Math.min(curr_min, price);
            res = Math.max(res, price - curr_min);
        }
        return res;
    }
}
