import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
            Input: integer array nums, integer target
            Output: integer array containing the two elements in nums summing in target

            - may not use same element twice. i.e. nums = [3,2,4], target = 6; not accepting [3,3]
            - only one answer exists

            Strategy
            1.) hashmap to store nums as complement to downstream element. values are index in nums TC: O(n), SC: O(n)
                - for each element, we find its complement (target-num) in the hashset. If not found, add itself into the map.

                HashMap <Integer, Integer> complements = new HashMap<Integer, Integer>();
                int [] result = new int[2];

                for (int i=0; i<nums.length; i++) {
                    if (complements.containsKey(target - nums[i])) {
                        result[0] = complements.get(target-nums[i]);
                        result[1] = i;
                        break;
                    }
                    complements.put(nums[i],i);
                }
                return result;
            
        */
        HashMap <Integer, Integer> complements = new HashMap<Integer, Integer>();
        int [] result = new int[2];

        for (int i=0; i<nums.length; i++) {
            if (complements.containsKey(target - nums[i])) {
                result[0] = complements.get(target-nums[i]);
                result[1] = i;
                break;
            }
            complements.put(nums[i],i);
        }
        return result;
        
    }
}