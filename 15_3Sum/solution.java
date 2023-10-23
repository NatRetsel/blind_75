class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
            Input: integer array nums
            Output: list of list of integers on the triplets summing to 0 and they have a unique index in nums.

            Strategy 
            - sort, then for every pair of numbers in nums, binary search the remaining range for the number
            that will add up to 0.
            - TC: sort O(nlogn), binary search O(logn), nested loop O(n2) total: O(n2), SC: O(n)

        */
        
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int target = 0;
        int left = 0;
        int mid = 0;
        int right = nums.length-1;
        int prev_i = Integer.MIN_VALUE;
        int prev_j = Integer.MIN_VALUE;
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++) {
            if (nums[i] == prev_i) continue;
            prev_i = nums[i];
            
            for (int j=i+1; j<nums.length-1; j++) {
                if (nums[j] == prev_j) continue;
                prev_j = nums[j];
                target = 0 - nums[i] - nums[j];
                left = j+1;
                right = nums.length-1;
                List<Integer> triplets = new ArrayList<Integer>();
                while (left <= right) {
                    mid = left + (right-left)/2;
                    if (nums[mid] == target) {
                        
                        triplets.add(nums[i]);
                        triplets.add(nums[j]);
                        triplets.add(nums[mid]);
                        res.add(triplets);
                        break;
                    }else if (nums[mid] < target) {
                        left = mid + 1;
                    }else{
                        right = mid-1;
                    }
                }
                
            }
        }
        return res;
    }
}
