import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays; 
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
            input: string array strs
            Output: list of list of string grouping the anagrams together.

            An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase
            typically using all the original letters exactly once.

            Strategy
            1.) hashmap with keys sorted string and values list of anagrams TC: O(mnlogn), SC: O(mn)
                - Anagrams have the same count for every character that exist.
                - by sorting the string and using it as the key, we can easily group anagrams together.     

        */
        HashMap<String, List<String>> anagram_map = new HashMap<String, List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();

        for(String str: strs){
            char ch_array[] = str.toCharArray();
            Arrays.sort(ch_array);
            String sorted_str = Arrays.toString(ch_array);
            if (anagram_map.containsKey(sorted_str)) {
                List<String> anagrams = anagram_map.get(sorted_str);
                anagrams.add(str);
                anagram_map.put(sorted_str, anagrams);
            }else{
                List<String> anagrams = new ArrayList<String>();
                anagrams.add(str);
                anagram_map.put(sorted_str,anagrams);
            }
        }
        
        for (List<String> value : anagram_map.values()) {
            result.add(value);
        }
        return result;
    }
}
