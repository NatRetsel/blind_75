class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        /*
            Inputs: vector of integer nums, integer k
            Output: vector of integers, the k most frequent element in any order

            We are guaranteed that the answer is unique

            sample test case
            1.) nums = [1,1,1,2,2,3], k = 2, output = [1,2]
                1 appears 3 times, 2 appears twice, 3 appears once, 2 most frequent elements are 1 and 2
            
            Strategy
            1.) Sort the array, get linear count and push it into max heap with frequency as the key
                - pop k times and push it into result vector.
                - TC: O(nlogn) from sorting O(n) for heap
            
            2.) Hashmap + maxHeap
                - obtain counts in linear time with a hashmap key will be the element and value is the count
                - push entries into maxHeap with count as key
                TC: O(n) time, O(n) space
                - worst case O(nlogn) time, O(n) space

                std::vector<tuple<int,int>>max_heap;
                std::unordered_map<int,int>count_map;
                std::vector<int>res;
                int count;
                int val;

                for (int elem:nums) {
                    count_map[elem]++;
                }

                for (auto &it:count_map) {
                    max_heap.push_back(std::make_tuple(it.second,it.first));
                }
                std::make_heap(max_heap.begin(),max_heap.end());

                for (int i=0; i<k; i++) {
                    std::pop_heap(max_heap.begin(),max_heap.end());
                    std::tie(count,val) = max_heap.back();
                    res.push_back(val);
                    max_heap.pop_back();
                }
                return res;
            
            3.) Hoare's selection algorithm O(N) avg, worst case O(n2)

            4.) Bucket sort trick
                - We know given nums, there are at most nums.size() different elements and at the opposite end, 
                    if all elements are the same, then that give at most a frequency of nums.size() for 
                    a particular element
                - We can initialize a bucket vector of vector of size nums.size()+1 where indices represent the
                frequency the elements appear. By doing so, we can iterate from the back of the bucket for the k most
                frequent element

        */
        std::unordered_map<int,int>count_map;
        std::vector<std::vector<int>> bucket(nums.size()+1);
        std::unordered_set<int>res_set;
        std::vector<int>res;
        for (int num:nums) {
            count_map[num]++;
        }
        for (auto &it:count_map) {
            bucket[it.second].push_back(it.first);
            
        }
        int i = nums.size();
        while (bucket[i].empty()) {
            --i;
        }
        
        while(k>0){
            for (int j = 0; j < bucket[i].size(); j++){
                
                if (res_set.find(bucket[i][j]) == res_set.end()) {
                    res_set.insert(bucket[i][j]);
                    res.push_back(bucket[i][j]);
                    --k;   
                }
            }
            --i;
        }
        return res;
    }
};