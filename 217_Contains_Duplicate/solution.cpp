class Solution{
public:
    bool containsDuplicates(std::vector<int> &nums) {
        /*
            Input: array of integers nums
            Output: boolean True if any value appears at least twice in the array, False if every element is distinct

            Strategy
            1.) use hashset for unique elements. if size of hashset < nums return false else true O(n) time O(n) space
                std::unordered_set <int> hashset(nums.begin(), nums.end());
                return hashset.size() < nums.size() ? true:false;
            2.) Treating each index as a linked list and element values as the next node to visit
                - cannot use because elements span negative as well

        */
        std::unordered_set <int> hashset(nums.begin(), nums.end()); //add every element in nums into hashset
        return hashset.size() < nums.size() ? true:false; // using ternary operator ? return true if size of hashset is smaller than nums
    }

};