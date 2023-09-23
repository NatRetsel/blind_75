class Solution {
public:
    int maxProfit(vector<int>& prices) {
        /* 
            Input: vector of integer prices
            Output: int max profit from buying and selling stock. If cannot achieve any profit return 0

            Constraints
            - only can choose a single day to buy and choosing a different day in the future to sell.

            Strategies
            1.) Brute force O(n2)
                - initialize profit to 0
                - run through all possible scenarios
                - outer loop across all elements except the last one. This loop represents buying
                    - inner loop from buy + 1 and the remaining elements. This loop represents selling
                        - shortlist the max profit each time.
                
                int res {0};
                for (int i = 0; i<prices.size()-1;i++){
                    for (int j = i+1; j < prices.size(); j++){
                        res = max(res, prices[j] - prices[i]);
                    }
                }
                return res;
            
            2.) Two pointers O(n)
                - inspired by max water in container
                - one initialized to the start of the array, one at the end
                - if prices[r] > prices[l], compute profit, shortlist max, reduce r
                - if prices[l] > prices[r], increase l

                - won't work for [2,1,4]. Assumption invalid
            
            3.) Kadane's algorithm O(n)
                - MOre logical approach is to store the current min we've seen so far, and compute profit and shortlist max.
                - loop through prices
                    - note the min price
                    - compute profit by taking current price minus min price seen so far. Shortlist max
                
                int min_price = INT_MAX;
                int profit = 0;
                for (int price:prices){
                    min_price = min(min_price, price);
                    profit = max(profit, price - min_price);
                }
                
        */
        int min_price = INT_MAX;
        int profit = 0;
        for (int price:prices){
            min_price = min(min_price, price);
            profit = max(profit, price - min_price);
        
        }
        return profit;
    }
    
};