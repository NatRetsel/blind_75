class Solution {
    public boolean compareMap(HashMap<Character, Integer> map1, HashMap<Character, Integer>map2) {
        if (!map1.keySet().equals(map2.keySet())) return false;
        for (char ch: map1.keySet()) {
            if (map1.get(ch) < map2.get(ch)) return false;
        }
        
        return true;
    }
    public String minWindow(String s, String t) {
        /*
            Input: String s, String t
            Output: String the minimum window substring, every character in t is included in the window.
            If there is no such substring, return the empty string "".

            Sample test cases
            1.) s = "ADOBECODEBANC", t = "ABC", output = "BANC"
                - "ADOBEC" - length 6
                - "BECODEBA" - length 8
                - "CODEBA" - length 6
                - "BANC" - length 4

            Strategy
            - Form the different substrings where every character in t (including) duplicates is included.
            - Since t may contain duplicates, we will need a hashmap to know if all the characters and 
            counts have been found.
            - while there exist characters with count < what is contained in t, expand the window
            - while all characters in the existing window >= what is contained in t,
                - shortlist length
                - reduce window size and remove character count
            - process continues as long as right end of window < length of s

            Alternatively
            - Fill up the character counts for characters present in t that are in s; 
                - begin with left: 0, right: s.length-1;
            - while character counts are >= those present in t, update length and reduce window size
        */
        HashMap<Character, Integer> s_map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> t_map = new HashMap<Character, Integer>();
        int count;
        int left = 0, right = 0;
        int n = s.length();

        String res = "";
        
        for (char ch: t.toCharArray()) {
            count = t_map.getOrDefault(ch,0);
            t_map.put(ch, count+1);
        }

        while (right < n) {
            while (right < n && !compareMap(s_map, t_map)) {
                if (t_map.containsKey(s.charAt(right))){
                    count = s_map.getOrDefault(s.charAt(right),0);
                    s_map.put(s.charAt(right),count+1);
                }
                ++right;
            }
            
            while (left < right & compareMap(s_map, t_map)) {
                if (res.length() == 0 || res.length() > right-left) res = s.substring(left,right);
                
                if (s_map.containsKey(s.charAt(left))) {
                    count = s_map.get(s.charAt(left));
                    s_map.put(s.charAt(left),count-1);
                    
                }
                ++left;
                
            }
            
        }
        return res;


    }
}
