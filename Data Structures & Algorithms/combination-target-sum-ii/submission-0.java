class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }

    void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tmp, int target, int start){
        if(target == 0){
            res.add(new ArrayList<> (tmp));
            return;
        }

        if(target<0)
            return;
        int n = nums.length;

        for(int i=start;i<n;i++){
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }

            tmp.add(nums[i]);
            backtrack(nums, res, tmp, target-nums[i], i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
