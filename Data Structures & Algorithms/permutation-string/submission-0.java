class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m)
            return false;

        int[] s1frq = new int[26];
        int[] s2frq = new int[26];

        for(int i=0;i<n;i++){
            s1frq[s1.charAt(i)-'a']++;
            s2frq[s2.charAt(i)-'a']++;
        }

        if(isMatched(s1frq, s2frq))
            return true;
        
        for(int i = n;i<m;i++){
            s2frq[s2.charAt(i-n)-'a']--;
            s2frq[s2.charAt(i)-'a']++;

            if(isMatched(s1frq, s2frq))
                return true;
        }
        return false;
    }

    public boolean isMatched(int[] arr1, int[] arr2){
        for(int i =0;i<26;i++){
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}
