class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        /*
            Input: vector of integers nums, integer target
            Output: vector of integers containing the index of the two numbers in nums that add up to target

            Constraints
            - cannot use same element twice
            - nums has a minimum length of 2

            Can assume that we have exactly one solution

            Sample test case
            1.) nums = [2,7,11,15], target = 9, output = [0,1]
                2 + 7 = 9, return 0 and 1
            
            Strategy
            1.) Brute force O(n2)
                - For every element, search the remaining elements if they add up to target. If yes return their index.
                bool found = false;
                std::vector<int> res;
                for (int i=0; i<nums.size()-1; i++) {
                    if (found){
                        break;
                    }
                    for (int j=i+1; j<nums.size(); j++) {
                        if (nums[i] + nums[j] == target) {
                            res.push_back(i);
                            res.push_back(j);
                            found = true;
                            break;
                        }
                    }
                }
                return res;
            
            2.) Linear search with hashmap
                - In similar fashion to checking if the other elements add up with the current element to target,
                we can ask if the current element is a complement to the previously found element that will sum to target.
                - In the first example,
                    nums = [2,7,11,15]
                    - In one loop, we ask if target - nums[i] is in the hashmap, if yes, we have the two index.
                    The hashmap will store the complement as key and index as value.

        */
        std::unordered_map<int,int>hashmap;
        std::vector<int> res;
        for (int i=0; i<nums.size(); i++){
            if (hashmap.find(nums[i]) != hashmap.end()) {
                res.push_back(hashmap[nums[i]]);
                res.push_back(i);
                break;
            }else{
                hashmap[target-nums[i]] = i;
            }
        }
        return res;
    }
};