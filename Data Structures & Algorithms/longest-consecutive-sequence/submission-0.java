class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums)
            set.add(num);

        int maxLen = 0;

        for(int num : nums){
            if(!set.contains(num-1)){
                int tmp = num;
                int cnt = 1;
                while(set.contains(++tmp)){
                    cnt++;
                }

                maxLen = Math.max(maxLen, cnt);
            }
        }
        return maxLen;
    }
}
