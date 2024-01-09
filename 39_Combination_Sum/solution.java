class Solution {
    private void backtrack(int[] candidates, int target, int currIdx, int currSum, List<Integer>currList, List<List<Integer>> res ) {
        if (currIdx == candidates.length) {
            if (currSum == target) {
                res.add(new ArrayList(currList));
            }
            return;
        }
        else if (currSum > target) return;
        else {
            currList.add(candidates[currIdx]);
            backtrack(candidates, target, currIdx, currSum + candidates[currIdx], currList, res);
            currList.remove(currList.size()-1);
            backtrack(candidates, target, currIdx+1, currSum, currList, res);
        }
        return;
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*
            Input: integer array candidates, integer target
            Output: list of list of integer all unique combinations of candidates where the
            chosen numbers sum to target.

            The same number may be chosen from candidates an unlimited number of times.

            Strategy
            1.) Backtracking
                - For each candidate, we have two choices - to pick or to skip
                - Since every number can be chosen unlimited amount of times, the range of choices won't decrease if we
                follow the template backtrack method
                - To allow of unique combinations, we restrict selection from currIdx onwards
                - terminating condition
                    - currIdx == candidates.length;
                        - check if currSum == target, if yes shortlist
                    - if currSum > target no need to go further
                    - for (int i=currIdx; i < candidates.length; i++) {
                        // pick
                        Array.add(i)
                        backtrack(candidates, i, target, currSum+candidates[i], Array);
                        
                        //skip
                        Array.remove(Array.size()-1)
                        backtrack(candidates, i+1, currSum, target, );
                    }
                    return;
        */
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> currList = new ArrayList<>();
        backtrack(candidates, target, 0, 0, currList, res);
        return res;
    }
}