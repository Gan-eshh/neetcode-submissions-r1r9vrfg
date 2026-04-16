class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), 0);
        return res;
    }

    void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tmp, int start){
        int n = nums.length;
        res.add(new ArrayList<>(tmp));

        for(int i=start;i<n;i++){
            if(i>start && nums[i] == nums[i-1])
                continue;
            tmp.add(nums[i]);
            backtrack(nums, res, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
