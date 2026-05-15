class Solution {
    public boolean hasDuplicate(int[] nums) {

        // Set<Integer> set = new HashSet<>();

        // for(int num : nums){
        //     if(set.contains(num))
        //         return true;
        //     set.add(num);
        // }
        // return false;
        Set<Integer> seen = new HashSet<>();
return Arrays.stream(nums).anyMatch(num -> !seen.add(num));
    }
}