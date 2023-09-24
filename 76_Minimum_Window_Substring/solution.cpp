class Solution {
public:
    string minWindow(string s, string t) {
        /*
            Input: Strings s and t
            Output: string minimum window substring of s such that every character in t (all counts) is in the window. else return ""

            Strategy:
            1.) Sliding window
                - one pass on string t and store the character counts in a hashmap
                - while r < s.length
                    - if right character exist in t 
                        - if count > 0 (we do not want to reduce when we encounter repeats that are not in t)
                            - decrement count
                        - decrement map count
                    expand window
                    - when count reaches 0, we found a potential match where all chars are in window
                        - shortlist min length -> update global min length and start and end pointer
                        - if left char in t
                            - increment map count 
                            - increment counter if map count > 0 (got rid of repeats not included in t)
                        shrink window
                
                if min length is still INT_MAX, return "" else s.substr(start, end-start+1)

        */

        int l = 0, r = 0, count = 0, start = 0, end = 0;
        int min_length = INT_MAX;
        std::unordered_map<char,int>t_count;
        for (char c:t){++t_count[c];++count;}

        while (r<s.length()){
            if (t_count.find(s[r])!= t_count.end()){
                if (t_count[s[r]] > 0){
                    --count;
                }
                --t_count[s[r]];
            }
            ++r;

            while (count == 0){
                if (r-l < min_length){
                    start = l;
                    end = r;
                    min_length = r-l;
                }
                if (t_count.find(s[l]) != t_count.end()) {
                    ++t_count[s[l]];
                    if (t_count[s[l]] > 0){
                        ++count;
                    }
                }
                ++l;
            }
        }

        if (min_length == INT_MAX){
            return "";
        }
        return s.substr(start,min_length);
        
    }
};