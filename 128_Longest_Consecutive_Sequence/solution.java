class Solution {
    public int longestConsecutive(int[] nums) {
        /*
            Input: array of unsorted integers nums
            Output: legnth of the longest consecutive elements sequence

            Constraints: write in O(n) time.

            Sample test case
            1.) nums = [100,4,200,1,3,2], output = 4
                - longest consecutive element sequence is [1,2,3,4]

            Strategy
            - if we ignore the linear time constraint, a naive solution would be to sort in order and check if the previous element
            is one off the current element.
            - What if we treated each element as a possible start to a sequence, then we are searching for element + 1
            - For such a possible sequence, we want to start at the smallest possible one and build from there
            - so as long as there exist a number smaller by 1 of itself, it means a longer streak can be built.
            - TC: O(2n), SC: O(n)


        */
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num: nums) num_set.add(num);
        int res = 0;
        for (int num:num_set) {
            if (!num_set.contains(num-1)) {
                // this is a possible starting point of a sequence
                int curr_num = num;
                int streak = 1;
                while (num_set.contains(curr_num+1)) {
                    curr_num += 1;
                    streak += 1;
                }
                res = Math.max(res,streak);
            }
        }
        return res;
    }
}
