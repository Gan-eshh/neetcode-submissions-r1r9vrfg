class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 1;
        int frq[] = new int[26];
        int maxFrq = 0;

        int l = 0;

        for(int r = 0;r<n;r++){
            char ch = s.charAt(r);
            frq[ch-'A']++;
            maxFrq = Math.max(maxFrq, frq[ch-'A']);

            while((r-l+1) - maxFrq > k){
                frq[s.charAt(l) - 'A']--;
                l++;
            }

            if((r-l+1) - maxFrq <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }
        }
        return maxLen;
    }
}
