class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0)
            return 0;
        Set<Character> set = new HashSet<>();

        int l = 0;
        int r = 0;
        int maxLen = 1;

        while(r < n){
            char ch1 = s.charAt(r);
            while(l < n && set.contains(ch1)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(ch1);
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}
