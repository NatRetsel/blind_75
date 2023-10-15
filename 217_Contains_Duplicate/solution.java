import java.util.HashSet;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        /*
            Input: integer array nums
            Output: boolean true if any value appears at least twice in the array, false if every element is distinct

            Strategy
            1.) Sort and iterate. TC: O(nlogn), SC: O(1)
                - Sorting the array allows ease of finding duplicated by comparing with the previous element
                Arrays.sort(nums);
                int prev = Integer.MIN_VALUE;
                for (int num: nums) {
                    if (num == prev) {
                        return true;
                    }
                    prev = num;
                }
                return false;


            2.) Hashset. TC: O(n), SC: O(n)
                - Set contains only unique elements
                - Iterate over all elements in the array, before adding elements into the hashset, if element already exist,
                  return true
                HashSet<Integer>set = new HashSet<Integer>();
                for (int num:nums) {
                    if (set.contains(num)) {
                        return true;
                    }
                    set.add(num);
                }
                return false;

        */
        HashSet<Integer>set = new HashSet<Integer>();
        for (int num:nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
        
    }
}