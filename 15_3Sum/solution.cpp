class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        /*
            Input: array of integers nums
            Output: vector of vector of integers, the triplets that sum to 0. Elements must not all come from the same index

            Sample test case
            1.) nums = [-1,0,1,2,-1,-4],
                output = [[-1,-1,2],[-1,0,1]]
            
            Strategy
            1.) Brute force O(n3)
                - sort input array
                - triple for loop computing the sum of triplets and shortlisting those that sum to 0 into a set to remove duplicates
                std::vector<std::vector<int>>res;
                std::unordered_set<tuple<int,int,int>>s;
                std::sort(nums);
                for (int i=0; i<nums.size()-2;i++){
                    for (int j=i+1; j<nums.size()-1;j++) {
                        for (int k=j+1; k<nums.size(); k++){
                            if (nums[i] +nums[j]+nums[k] == 0) {
                                if (s.find((nums[i],nums[j],nums[k])) == s.end()){
                                    res.push_back(std::vector<int>{nums[i], nums[j],nums[k]});
                                    s.insert((nums[i],nums[j],nums[k]));
                                }
                            }
                        }
                    }
                }
                return res;

            2.) Extending from 2sum 2
                - Sorting array helps us deal with repeats
                - for each element in nums, we run two sum 2 on the remaining subarray
                
                

        */
        std::vector<vector<int>>res;
        std::sort(nums.begin(), nums.end());
        int l,r, target;
        for (int i=0; i< nums.size()-2;i++){
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            l = i+1;
            r = nums.size()-1;
            target = 0 - nums[i];
            while (l<r) {
                if (l<r && nums[l]+nums[r] > target){
                    --r;
                }else if (l<r && nums[l]+nums[r] < target){
                    ++l;
                }else{
                    res.push_back({nums[i],nums[l],nums[r]});
                    ++l;
                    while (l<r && nums[l] == nums[l-1]) {
                        ++l;
                    }
                    --r;
                    while (l<r && nums[r] == nums[r+1]) {
                        --r;
                    }
                    

                }
            }
        }
        return res;
        
        
    }
};