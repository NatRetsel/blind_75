class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        /*
            Inputs: vector of string strs
            Output: vector of vector of string where each vector in vector contains the group of anagrams
            Return the result in any order

            Anagram: a word or phrase formed by rearranging the letters of a different word or phrase, typically using all original
            letters exactly once.

            If all words are not anagrams of each other then each word is an anagram group of itself.

            Strategy
            1.) Brute force-ish TC: O(n*l) n is length of strs, l is max length of a string in nums SC: O(n)
            Have hashmap mapping the index of the unique anagrams to the hashmap counts of their characters
            Have another hashmap with keys as the indices of these strings mapped to the index of unique anagrams matched earlier.
            - Dealing with empty string becomes convoluted

            std::unordered_map<char,int>curr_map;
            std::unordered_map<int, std::unordered_map<char,int>>anagram_map;
            std::unordered_map<int,std::vector<std::string>>res_map;
            std::vector<std::vector<std::string>>res;
            std::vector<string>empty_str;
            int count {0};
            int empty {0};
            for (int i=0; i<strs.size(); i++) {
                if (strs[i].empty()) {
                    ++empty;
                }
                for (char c: strs[i]){
                    curr_map[c]++;
                }
                for (auto &it:anagram_map) {
                    if (curr_map == it.second) {
                        res_map[it.first].push_back(strs[i]);
                        curr_map.clear();
                        break;
                    }
                }
                if (!curr_map.empty()){
                    anagram_map[count] = curr_map;
                    res_map[count].push_back(strs[i]);
                    curr_map.clear();
                    ++count;
                }
            }

            for (auto &it: res_map){
                res.push_back(it.second);
            }
            if (empty > 0){
                for (int i=0; i<empty;i++){
                    empty_str.push_back("");
                }
                res.push_back(empty_str);
            }

            return res;
            
            2.) Finding anagrams by sorting the string O(n2logn) SC:O(n)
            - This way we can hash the sorted string as keys and values will contain the vector of strings that are anagrams
            std::unordered_map<std::string,std::vector<std::string>>anagram_map;
            std::string copy;
            std::vector<std::vector<std::string>>res;
            for (std::string s: strs){
                copy = s;
                std::sort(copy.begin(), copy.end());
                anagram_map[copy].push_back(s);
            }
            for (auto &it: anagram_map){
                res.push_back(it.second);
            }
            return res;

        */
        std::unordered_map<std::string,std::vector<std::string>>anagram_map;
        std::string copy;
        std::vector<std::vector<std::string>>res;
        for (std::string s: strs){
            copy = s;
            std::sort(copy.begin(), copy.end());
            anagram_map[copy].push_back(s);
        }
        for (auto &it: anagram_map){
            res.push_back(it.second);
        }
        return res;
    
    }
};