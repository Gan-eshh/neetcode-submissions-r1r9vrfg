class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int maxPro = nums[0];
        
        for(int i=0;i<n;i++){
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[n-i-1];

            maxPro = Math.max(maxPro, Math.max(leftProduct, rightProduct));
        }
        return maxPro;
    }
}
