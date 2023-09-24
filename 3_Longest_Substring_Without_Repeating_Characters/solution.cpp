class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        /*
            Input: string s
            Output: integer the longest substring without repeating characters

            Substring -> contiguous

            Strategy
            1.) Brute force form every substring and set it and shortlist those lengths are equal to set length
                TC: O(n2), SC: O(n)
                int res {1};
                for (int i=0; i < s.length()-1; i++){
                    std::string sub_str = std::string(1,s[i]);
                    std::unordered_set<char> unique {s[i]};
                    
                    for (int j=i+1; j < s.length(); j++) {
                        if (unique.find(s[j]) == unique.end()) {
                            sub_str += s[j];
                            unique.insert(s[j]);
                            res = max(res,(int)unique.size());
                            
                        }else{
                            break;
                        }
                    }
                }
                return res;

            2.) Sliding window TC: O(2n), SC: O(w)
                - Since substring needs to be contiguous. The problem can be equated to longest window of unique characters
                - Have two pointers both beginning at start of string
                - have an unordered_set for unique characters
                - if char at right pointer is not in set, add it, increment right pointer, shortlist max length (expand window)
                - if char at right pointer is in set, remove character at left pointer from the set, increment left pointer (shrink)
                - Do this while r < s.length();

                int l = 0, r=0, res=0;
                int n = s.length();
                std::unordered_set<char>unique;
                while (r < n) {
                    if (unique.find(s[r]) == unique.end()) {
                        unique.insert(s[r]);
                        ++r;
                        res = max(res, r-l);
                    }else{
                        unique.erase(s[l]);
                        ++l;
                    }
                }
                return res;

            3.) Hashmap optimization to skip characters TC: O(n), SC: O(n)
                - At one go, if we have encountered this character before, we can shrink our window 
                - because we are already updating our max result length every time in the loop,
                    - we can skip across multiple index
        */
        int res=0;
        int n = s.length();
        std::unordered_map<char, int>unique;
        for (int i=0, j=0; i<n; i++){
            if (unique[s[i]] > 0) {
                j = max(unique[s[i]], j);
            }
            res = max(res, i-j+1);
            unique[s[i]] = i+1;
        }
        return res;
    }
};