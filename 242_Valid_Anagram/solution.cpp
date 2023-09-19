class Solution {
public:
    bool isAnagram(string s, string t) {
        /*
            Input: string s and t
            Output: boolean true if t is an anagram of s, false otherwise

            anagram: A word or phrase formed by rearranging the letters of a different word or phrase, typically using all
            original letters exactly once.

            Sample test case
            1.) s = "anagram", t = "nagaram"
                s -> 3 "a"s, 1 "n", 1 "g", 1 "r", 1 "m"
                t -> 3 "a"s, 1 "n", 1 "g", 1 "r", 1 "m"
                letters and counts are the same, t is an anagram of s
            
            2.) s = "rat", t = "car"
                s -> 1 "r", 1 "a", 1 "t"
                t -> 1 "c", 1 "a", 1 "r"
                letters and counts are not the same, t is not an anagram of s
            
            Strategy
            1.) hashmap tracking the counts of each character in both strings, O(s+t), O(s+t)
                - we will return hashmap_s == hashmap_t
                - Can speed things up by returning false if the length differs

            2.) Single hashmap O(s+t), O(s)
                - count characters in s
                - reduce count for characters in t
                - Go through the hashmap, if there are characters with count of != 0, return false

            3.) sort both strings then compare O(slogs) + O(tlogt), O(1)
        */

        if (s.size() != t.size()) {
            return false;
        }

        std::unordered_map<char,int> hashmap_s;
        

        for (char c:s){
            // we do not have to check whether key exist due to default initialisation of 0 of standard types
            hashmap_s[c]++;
        }

        for (char c:t){
            hashmap_s[c]--;
        }

        for (auto c:hashmap_s) {
            if (c.second != 0) {
                return false;
            }
        }

        return true;
        
    }
};