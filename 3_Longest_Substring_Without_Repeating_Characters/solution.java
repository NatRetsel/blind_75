class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
            Input: String s
            Output: int the length of longest substring without repeating characters

            substring: contiguous non empty sequence

            Strategy
            1.) Double nested loop + hashset. TC: O(n2), SC: O(n)
                - outer loop will determine the starting character of the longest substring, add into hashset
                - initialize length at 1, empty hashset
                - inner loop tries to find the longest substring without repeating characters
                    - begin at one plus outer index
                    - if character is not in hashset, add into hashset and increment length
                    - if character is in hashset break
                    - outside of inner loop, shortlist length of longest substring without repeating characters.
            
            2.) Sliding window + hashset
                - Aim to construct the longest substring without repeating characters with the window
                - Length of window will be the answer
                - Have two pointers left and right beginning at index 0
                - Run the loop until right reaches out of bounds.
                - if the character at right index is not in hashset, increment right
                - if character at right index is in hashset, shortlist current max length
                    - remove character at left index from hashset, increment left pointer
        */
        int left = 0, right = 0, res = 0;
        int n = s.length();
        HashSet<Character> seen = new HashSet<Character>();
        while (right < n) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                ++left;
            }
            seen.add(s.charAt(right));
            ++right;
            res = Math.max(res, right-left);

        }
        return res;
    }
}
