class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        /*
            Input: vector of integers nums
            Output: vector of integers where answer[i] is the product of all element of nums except nums[i]

            Sample test case
            1.) nums = [1,2,3,4]
                output = [24,12,8,6]
                [2*3*4, 1*3*4, 1*2*4, 1*2*3]

            2.) nums = [-1,1,0,-3,3]
                output = [0,0,9,0,0]

            Constraint: O(n) without using division

            prefix product: [1,2,6,8]
            suffix product: [24,24,12,4]

            prefix product: [-1,-1,0,0,0]
            suffix product: [0,0,0,-9,3]

            Strategy:
            1.) compute prefix and suffix product in their own respective arrays TC: O(n), SC: O(n)
                - answer[i] will be prefix[i-1] * suffix[i+1] if i-1 and i+1 are not out of bounds else will just
                do with the valid bound.

                std::vector<int>prefix_prod(nums.size(),nums[0]);
                std::vector<int>suffix_prod(nums.size(),nums[nums.size()-1]);
                std::vector<int>res(nums.size(),0);

                for (int i=1; i<nums.size(); i++){
                    prefix_prod[i] = prefix_prod[i-1] * nums[i];
                    suffix_prod[nums.size()-1-i] = suffix_prod[nums.size()-i] * nums[nums.size()-1-i];
                }
                res[0] = suffix_prod[1];
                res[nums.size()-1] = prefix_prod[nums.size()-2];
                for (int i=1; i<nums.size()-1; i++){
                    res[i] = prefix_prod[i-1]*suffix_prod[i+1];
                }
                return res;

            Follow up: solve in O(1) space not counting output array.
            a. use prefix array as the results array, compute suffix prod on the fly and adjust values in prefix array
                std::vector<int>res(nums.size(),nums[0]);
                int suffix_prod {1};

                // prefix prod
                for (int i=1; i<nums.size(); i++){
                    res[i] = res[i-1] * nums[i];
                }
                
                //suffix prod
                for (int i=nums.size()-1; i>0; i--){
                    res[i] = res[i-1] * suffix_prod;
                    suffix_prod = suffix_prod * nums[i];
                }
                res[0] = suffix_prod;
                return res;

        */
        std::vector<int>res(nums.size(),nums[0]);
        int suffix_prod {1};

        // prefix prod
        for (int i=1; i<nums.size(); i++){
            res[i] = res[i-1] * nums[i];
        }
        
        //suffix prod
        for (int i=nums.size()-1; i>0; i--){
            res[i] = res[i-1] * suffix_prod;
            suffix_prod = suffix_prod * nums[i];
        }
        res[0] = suffix_prod;
        return res;
    }
};