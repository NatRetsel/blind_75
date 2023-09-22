class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        /*
            Input: vector of integers nums
            Output: integer the length of the longest consecutive elements sequence

            Constraints
                - O(n) algorithm
                - nums can be empty

            Sample test case
            1.) nums = [100,4,200,1,3,2], output = 4
                - [1,2,3,4] is the longest consecutive elements sequence. 
            
            Strategy
            1.) Ignoring constraints, sorting and linear probe 
                [1,2,3,4,100,200] - index 0 to 3 differ by 1, they are consecutive
                - Know that sorting takes nlogn. Is there a way to do without sorting?
                - hashset? if element is not found in hashset, we check if its +1 and -1 is in
                {100,4} -> max length = 1
                {100,4,200,1}-> max length = 1
                {100,4,200,1,3} -> 3+1 found, max length = 2
                {100,4,200,1,3,2} -> 2+1 found, 2-1 found, maxlength += 2; 4

                This would not work for sequence that are disjointed
            
                nums = [0,3,7,2,5,8,4,6,0,1]
                {0,3,7} -> max length = 1
                {0,3,7,2} -> max length = 2
                {0,3,7,2,5}-> max length = 2
                {0,3,7,2,5,8} -> max length = 2 but algo will makes it 4

                Why don't we store every element in the set first to remove duplicates
                then for every element in the set, we look for possible beginning of a sequence i.e. minus one of itself
                does not exist in the set, then these are possible sequence starters and let's count the length and update result.
                Solution looks like O(n2) because of the double loop, but the condition to check for the start of a sequence makes it O(n)


        */
        std::unordered_set<int> s(nums.begin(), nums.end());
        int res {0};
        int i {0};
        for (int elem:s){
            if (s.find(elem-1) == s.end()){
                i = 0;
                while (s.find(elem+i)!=s.end()){
                    ++i;
                }
                res = max(res,i);
            }
        }
        return res;
    }
};