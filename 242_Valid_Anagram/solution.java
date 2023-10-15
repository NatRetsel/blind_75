import java.util.HashMap;
import java.util.Arrays;
class Solution {
    public boolean isAnagram(String s, String t) {
        /*
            Input: string s, string t
            Output: boolean true if t is an anagram of s, false otherwise

            anagram: a word or phrase formed by rearranging the letter of a different word or phrase, typically using all
            original letters exactly once.

            Strategy
            1.) Hashmap with characters as keys, counts as value. TC: O(s+t), SC: O(s+t)
                - both hashmap should match
                HashMap <Character, Integer> s_map = new HashMap <Character, Integer>();
                HashMap <Character, Integer> t_map = new HashMap <Character, Integer>();

                for (int i=0; i<s.length(); i++) {
                    int count = s_map.getOrDefault(s.charAt(i), 0);
                    s_map.put(s.charAt(i), count+1);
                }

                for (int i=0; i<t.length(); i++) {
                    int count = t_map.getOrDefault(t.charAt(i), 0);
                    t_map.put(t.charAt(i), count+1);
                }
                return s_map.equals(t_map);

            2.) Sort and iterate TC: O((slogs + tlogt), SC:O(1)
                - after sorting, character across each index should match
                if (s.length() != t.length()) {return false;}
                char s_array[] = s.toCharArray();
                char t_array[] = t.toCharArray();
                Arrays.sort(s_array);
                Arrays.sort(t_array);
                for (int i=0; i<s_array.length; i++) {
                    if (s_array[i] != t_array[i]) {
                        return false;
                    }
                }
                return true;


        */
        if (s.length() != t.length()) {return false;}
        char s_array[] = s.toCharArray();
        char t_array[] = t.toCharArray();
        Arrays.sort(s_array);
        Arrays.sort(t_array);
        for (int i=0; i<s_array.length; i++) {
            if (s_array[i] != t_array[i]) {
                return false;
            }
        }
        return true;
        
    }
}