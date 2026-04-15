class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, res, new ArrayList<>(), target, 0);
        return res;
    }

    void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp, int target, int start){
        int n = nums.length;
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target<0)
            return;

        for(int i=start;i<n;i++){
            if(nums[i] <= target){
                temp.add(nums[i]);
                backtrack(nums, res, temp, target-nums[i], i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
