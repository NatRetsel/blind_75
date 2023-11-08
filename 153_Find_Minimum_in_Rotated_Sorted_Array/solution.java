class Solution {
    public int findMin(int[] nums) {
        /*
            Input: integer array nums. It is sorted in ascending order and rotated between 1 and n times
            output: integer the minimum value in nums

            if array is rotated less than n times,
            - left end > right end
            - there are two segments of sorted ascending portions in the array
            - meaning if array is rotated, we can find the min on the right portion.

            - To search, we will use binary search
            - initialize two pointers left and right beginning at the start and end of the array respectively.
            - while left pointer is less than right pointer
                - compute mid index
                - if value of left pointer is greater than value of right pointer
                    - we want to search for the right sorted portion
                        - if mid value < right value
                            - shift right to mid-1
                        - else shift left to mid+1
                - else (means we found the correct portion / array is shifted n times)
                    - return left
                    
        */

        int left=0;
        int right = nums.length - 1;
        int mid = Integer.MAX_VALUE;

        while (left < right) {
            mid = left + (right-left)/2;
            if (nums[left] > nums[right]) {
                if (nums[mid] < nums[right]) {
                    right = mid;
                }else{
                    left = mid+1;
                }
            }else{
                break;
            }
        }
        return nums[left];
    }
}
