class Solution {
    public boolean isPalindrome(String s) {
        /*
            Input: String s
            Output: Boolean true if s, after removing all non-alphanumeric characters and converting all into lowercase letters,
            is a palindrome.

            Strategy
            1.) two pointers, one beginning at the front, one beginning at the end
                - while the left pointer is less than the right pointer
                    - while character on the left is not alphanumeric, increment left pointer
                    - while character on the right is not alphanumeric, decrement right pointer
                    - if the lowercase letters at both pointers do not match, return false
                    - else means it matches, increment left pointer and decrement right pointer
        */
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            while (left < s.length() && !Character.isLetterOrDigit(s.charAt(left))) ++left;
            while (right >=0 && !Character.isLetterOrDigit(s.charAt(right))) --right;
            if(left < s.length() && right >= 0 && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            ++left;
            --right;
        }
        return true;
    }
}
