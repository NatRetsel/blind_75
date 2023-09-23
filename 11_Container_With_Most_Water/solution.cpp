class Solution {
public:
    int maxArea(vector<int>& height) {
        /*
            Input: vector of integers height, each element in height represents the height of vertical lines
            output: integer the max amount of water a container formed by 2 lines in height can store

            Strategy
            1.) Two pointers, one beginning at the start and the other at the end of the array
                - int result;
                - While (l < r)
                    - res = max(res, (min(height[l],height[r]) * (r-l)))
                    - if height[l] < height[r], increment i
                    - if height[r] < height[l], decrement r
                - Why shift the smaller height
                    - volume of water is dictated by the smaller height
                    - given 2 heights, we are better off changing the height of the shorter one and find a larger one
                    simply because changing the height of the larger one will not give us an increase in area, while the converse
                    MAY lead us to a better outcome.
                        
        */
        int l = 0;
        int r = height.size()-1;
        int res = 0;
        while (l < r) {
            res = max(res, min(height[l],height[r]) * (r-l));
            if (height[l] <= height[r]) {
                ++l;
            }else{
                --r;
            }
        }
        return res;

    }
};