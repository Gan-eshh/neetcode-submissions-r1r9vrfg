class Solution {
    public String minWindow(String s, String t) {

        int n = s.length();
        int m = t.length();

        if(m > n)
            return "";

        int sfrq[] = new int[128];
        int tfrq[] = new int[128];
        
        for(char ch : t.toCharArray())
            tfrq[ch]++;
        int start = -1;
        int minLen = n+1;
        
        int l = 0;
        for(int r = 0;r<n;r++){
            sfrq[s.charAt(r)]++;
            while(isMatched(sfrq, tfrq)){
                if(minLen > r-l+1){
                    start=l;
                    minLen = r-l+1;
                }
                sfrq[s.charAt(l)]--;
                l++;
            }
        }  
        return minLen == n+1 ? "" : s.substring(start, start+minLen);
    }

    public boolean isMatched(int[] a1, int[] a2){
        for(int i=0;i<128;i++){
            if(a1[i] < a2[i])
                return  false;
        }
        return true;
    }
}
