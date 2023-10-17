class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
            Input: integer array nums, integer k
            Output: intger array the k most frequent elements

            Sample test case
            1.) nums = [1,1,1,2,2,3], k = 2
                - output = [1,2], 1 and 2 are the 2 most frequent elements in nums

            2.) nums = [1], k = 1
                - output = [1]
            
            We are guaranteed the answer is unique, min length nums is 1

            Strategy
            1.) heap/priority queue ordering in terms of counts TC: O(nlogn), SC: O(n)
                - pop the k most frequent elements, push into array
                - return
            
            Follow up: TC better than O(nlogn). TC: O(n), SC: O(n)
            - What options are available if we don't want to sort conventionally?
            - bucket sort
                - hashmap to count elements
                - let the count be the bucket index, we populate the elements with the count in the buckets
                - let the other buckets be empty. Initial bucket of size number of elements in array (worst case)
                - iterate from the back of the bucket and find valid k numbers
        */
        List<Integer>[] bucket = new List[nums.length +1];
        HashMap<Integer,Integer>count_map = new HashMap<Integer,Integer>();
        List<Integer> res = new ArrayList<>();
        int idx=0;
        for (int num: nums){
            count_map.put(num,count_map.getOrDefault(num,0)+1);
        }
        for(int key: count_map.keySet()){
            
            if (bucket[count_map.get(key)] == null){
                bucket[count_map.get(key)] = new ArrayList<>();    
            }
            bucket[count_map.get(key)].add(key);
        }

        for (int i=bucket.length-1; i>=0 && res.size()<k; i--){
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}
