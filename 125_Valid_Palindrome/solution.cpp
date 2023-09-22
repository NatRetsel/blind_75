class Solution {
public:
    bool isPalindrome(string s) {
        /*
            Input: string s
            Output: boolean true if after converting all into lowercase letters and removing all non-alphanumeric characters,
            the string is a palindrome. False otherwise. An empty string is a palindrome.

            Check palindrome:
                - two pointers one at beginning one at the end
                    - return false when the characters are not the same;

        */
        int l = 0;
        int r = s.size()-1;
        while (l < r) {
            if(!std::isalnum(s[l])){++l; continue;}
            if(!std::isalnum(s[r])){--r; continue;}
            if(std::tolower(s[l])!=std::tolower(s[r])){
                return false;
            }else{
                ++l;
                --r;
            }
        }
        return true;
    }
};