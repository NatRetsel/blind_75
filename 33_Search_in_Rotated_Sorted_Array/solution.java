class Solution {
    public int search(int[] nums, int target) {
        /*
            Input: integer array nums, integer target
            Output: index of target if present in nums else -1

            Observation
            - rotated array consists of two sorted arrays
            - we want to determine first in which sorted array is target located in
                - We can do it through binary search
                - first determine that current array is rotated
                    - if nums[left] > nums[right]
                - if nums[mid] is target, return mid (got it by chance or with subsequent searches)
                - if it is rotated 
                    
                    - we check with nums[mid] if it is < than nums[right] (mid is located on the right side arr)
                        - if target lies between mid and right, we can shift left to mid + 1
                        - else shift right to mid (narrow search range to left side arr since target lies there)
                    - else it means mid is located in the left side arr
                        - if target lies between mid and left, shift right to mid-1
                        - else shift left to mid
                - else we have already narrowed the "right" array
                    - if nums[mid] < target
                        - search right
                    - else
                        - search left
        */
        int left=0;
        int right=nums.length-1;
        int mid;

        while (left <= right) {
            mid = left + (right-left)/2;
            if (nums[mid] == target) return mid;
            if (nums[left] > nums[right]) {
                if (nums[mid] < nums[right])
                    if (target >= nums[mid] && target <= nums[right]) 
                        left = mid+1;
                    else
                        right = mid-1;
                else
                    if (target >= nums[left] && target <= nums[mid]) 
                        right = mid-1;
                    else
                        left = mid+1;
                       
            }else{
                if (nums[mid] < target) {
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
