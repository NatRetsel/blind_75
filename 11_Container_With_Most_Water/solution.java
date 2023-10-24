class Solution {
    public int maxArea(int[] height) {
        /*
            Input: integer array heights
            Output: integer the maximum amount of water a container can store

            Strategy
            - Since amount of water held is limited by the smaller height, beginning with two pointers one at the start
            and another pointing at the end, we shortlist the max amount and move the pointer pointing at the smaller height
            - TC: O(n), SC: O(1)
        */
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right])*(right-left));
            if (height[left] < height[right]) {
                ++left;
            }else{
                --right;
            }
        }
        return res;
    }
}
