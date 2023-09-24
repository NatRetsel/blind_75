class Solution {
public:
    int characterReplacement(string s, int k) {
        /*
        Inputs: string s, integer k
        Output: integer the length of the longest substring containing the same letter after performing at most k operations

        Operations: replacing any character in string to any other uppercase English character.


        Strategy
        1.) Brute force O(26n)
            - form every substring and check if the number of remaining characters after length sub string - the most frequent char
            is <= k. If yes, it means we can have a substring of a single character of length length. Shortlist the max length
            - Let's start with an array or hashmap of 26 (representing characters). The elements of values will hold the count of 
            the characters in the current window

            std::vector<int>count(26,0);
            int l = 0, r = 0, max_count = 0, res = 0;
            while (r<s.length()){
                count[s[r] - 'A']++;
                max_count = 0;
                for (int i=0; i<26; i++){
                    max_count = max(max_count,count[i]);
                }
                if (r-l+1 - max_count >k){
                    count[s[l] - 'A']--;
                    l++;
                }else{
                    res = max(res, r-l+1);
                    
                }
                r++;
                
            }
            return res;
            
        2.) O(n) approach, maintain the max frequency count and not update it. This works because result only depends on length
        and max count. If there's a decrease in max count, our result won't change.

        */

        std::vector<int>count(26,0);
        int l = 0, r = 0, max_count = 0, res = 0;
        while (r<s.length()){
            count[s[r] - 'A']++;
            max_count = max(max_count,count[s[r] - 'A']);
            
            if (r-l+1 - max_count >k){
                count[s[l] - 'A']--;
                l++;
            }
            res = max(res, r-l+1);    
            r++;
            
        }
        return res;
        

    }
};