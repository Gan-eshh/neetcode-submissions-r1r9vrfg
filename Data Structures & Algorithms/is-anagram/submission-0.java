class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n != m)
            return false;
        
        int[] fq = new int[26];

        for(int i=0;i<n;i++){
            fq[s.charAt(i) - 'a']++;
            fq[t.charAt(i) - 'a']--;
        }

        for(int num : fq){
            if(num != 0)
                return false;
        }
        return true;
    }
}
