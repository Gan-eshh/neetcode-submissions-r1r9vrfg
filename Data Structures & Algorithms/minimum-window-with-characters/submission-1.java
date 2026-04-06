class Solution {
    public String minWindow(String s, String t) {

        int[] freq = new int[128];

        for(char c : t.toCharArray())
            freq[c]++;

        int l = 0;
        int r = 0;
        int required = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while(r < s.length()){

            if(freq[s.charAt(r)] > 0)
                required--;

            freq[s.charAt(r)]--;
            r++;

            while(required == 0){

                if(r - l < minLen){
                    minLen = r - l;
                    start = l;
                }

                freq[s.charAt(l)]++;

                if(freq[s.charAt(l)] > 0)
                    required++;

                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}