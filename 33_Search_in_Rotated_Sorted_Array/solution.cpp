class Solution {
public:
    int search(vector<int>& nums, int target) {
        /*
            Input: vector of integers nums initially sorted in ascending order with distinct values and rotated, integer target
            Output: integer the index of target if in nums else -1

            Rotated: shift left

            Constraints: write in O(logn)

            Binary search in a sorted rotated array

            Sample test case
            1.) nums = [4,5,6,7,0,1,2], target = 0, output: 4
                - if array is not rotated -> binary search as per normal
                - if array is rotated, there exist a partition where both sides are sorted themselves
                - We can narrow down which half target will be with the following conditions
                    - if leftmost element <= middle
                        - if target resides in between leftmost and middle:
                            - search left
                        - else search right
                    - if leftmost element > middle
                        - if target element is smaller than middle yet it is smaller than right bound
                            - search right
                        - else search left
                
        */

        int l = 0;
        int r = nums.size()-1;
        int mid;

        while (l<=r) {
            mid = l + (r-l)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target <= nums[mid]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else{
                if (nums[mid] <= target && target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
            
        }
        return -1;
        
    }
};