class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // boolean[] contains = new boolean[nums.length];
        backtrack(nums, res, new ArrayList<>());
        return res;
    }

    void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tmp){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            // if(!map[i]){
                // map[i] = true;
                if(tmp.contains(nums[i]))
                    continue;
    
                tmp.add(nums[i]);
                backtrack(nums, res, tmp);
                tmp.remove(tmp.size()-1);
                // map[i] = false;
            // }
        }
    }
}
