lass Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
            Input: array of integer nums
            Output: array of integer such that array[i] is the product of all elements in nums except nums[i]
            Constraint: Write an algorithm running in O(n) time and without using the division operation.

            Strategy
            1.) Ignoring the O(n) constraint, one might expand left and right wards and compute the cumulative
            product of the elements in nums except itself. A neat observation here will be that we can
            treat the left and right ward computation separate before multiplying the results from both
            sides together.

            Extending this to the idea of prefix sum, we can create the left products: prefix product
            and right products: suffix product with a total of two arrays. The leftmost element of the 
            prefix product and rightmost element in the suffix product array will be nums[0] and nums[len-1]

            Using example 1
            - prefix product: [1,2,6,24]
            - suffix product: [24,24,12,4]
            - for each index, the result will be prefix product[i-1] * suffix_product[i+1]
            - if index is out of bounds, we can treat the prefix / suffix product as 1.

            TC: O(n), SC: O(n)

            int[] prefix_prod = new int[nums.length];
            int[] suffix_prod = new int[nums.length];
            int[] result = new int[nums.length];

            for (int i=0; i < nums.length; i++){
                if (i==0){
                    prefix_prod[i] = nums[i];
                    suffix_prod[nums.length-1] = nums[nums.length-1];
                }else{
                    prefix_prod[i] = nums[i] * prefix_prod[i-1];
                    suffix_prod[nums.length-1-i] = nums[nums.length-1-i] * suffix_prod[nums.length-i]; 
                }
            }

            for (int i=0; i < nums.length; i++) {
                if (i==0) {
                    result[i] = suffix_prod[i+1];
                }else if (i == nums.length-1) {
                    result[i] = prefix_prod[i-1];
                }else{
                    result[i] = prefix_prod[i-1] * suffix_prod[i+1];
                }
            }

            return result;

            Follow up: Solving in O(1) extra space, not including output array.
            - let the output array be the prefix-product array
            - result = [1,2,6,24]
            - As we compute the suffix product, we can compute the result and replace the elements in result array
            - [1,2,6,6], suffix prod = 4 
            - [1,2,8,6], i = 2, res[i] = res[i-1] * suffix prod, update suffix prod = 12, 
            - [1,12,8,6], i = 1, update suffix prod = 24
            - [24,12,8,6]

            int[] result = new int[nums.length];
            int suffix_prod = nums[nums.length-1];

            for (int i=0; i < nums.length; i++){
                if (i==0){
                    result[i] = nums[i];
                }else{
                    result[i] = nums[i] * result[i-1];
                }
            }

            for (int i=nums.length-1; i >= 0; i--) {
                if (i==nums.length-1){
                    result[i] = result[i-1];
                }else if (i == 0){
                    result[i] = suffix_prod;
                }else{
                    result[i] = result[i-1] * suffix_prod;
                    suffix_prod *= nums[i];
                }
                
            }

            return result;
        */

        int[] result = new int[nums.length];
        int suffix_prod = nums[nums.length-1];

        for (int i=0; i < nums.length; i++){
            if (i==0){
                result[i] = nums[i];
            }else{
                result[i] = nums[i] * result[i-1];
            }
        }

        for (int i=nums.length-1; i >= 0; i--) {
            if (i==nums.length-1){
                result[i] = result[i-1];
            }else if (i == 0){
                result[i] = suffix_prod;
            }else{
                result[i] = result[i-1] * suffix_prod;
                suffix_prod *= nums[i];
            }
            
        }

        return result;
    }
}
