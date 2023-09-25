class Solution {
public:
    int findMin(vector<int>& nums) {
        /*
            Input: vector of integers nums of unique elements sorted and rotated
            Output: integer the smallest element

            Constraint: O(logn) solution

            Sample test case
            1.) nums = [3,4,5,1,2], output = 1

            2.) nums = [4,5,6,7,0,1,2], output = 0

            3.) nums = [11,13,15,17], output = 11

            Consider the following cases
            a. [3,4,5,1,2], [1,2,3,4,5], [5,1,2,3,4]
                - if array is rotated, then left most element will be > right most element
                    - start from mid
                    - shortlist the smallest element into a results variable each time.
                    - if mid value is greater than left element, then smallest value is somewhere on the right
                    - else left
                - if not rotated, return first element.

                int l = 0;
                int r = nums.size()-1;
                int mid = 0;
                int res = nums[0];
                while (l<=r) {
                    if (nums[l] < nums[r]){
                        res = min(res,nums[l]);
                        break;
                    }
                    mid = l+(r-l) / 2;
                    res = min(res, nums[mid]);

                    if (nums[mid] >= nums[l]){
                        l = mid+1;
                    }else{
                        r = mid-1;
                    }
                }
                
                return res;

            b. slight optimisation, do we need to run the entire search?
                - stop conditions 
                    - when nums[mid] > nums[mid+1] -> nums[mid+1] is the smallest
                    - when nums[mid-1] > nums[mid] -> nums[mid] is the smallest
                
        */
        int l = 0;
        int r = nums.size()-1;
        int mid = 0;
        int res = nums[0];
        if (l==r){return nums[0];}
        if (nums[l] < nums[r]){
            return min(res,nums[l]);
        }
        while (l<=r) {
            mid = l+(r-l) / 2;
            
            if (nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }

            if (nums[mid-1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        
        return res;
    }
};