class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1)
            return s;
        String longestPali = s.substring(0, 1);

        for(int i=0;i<n;i++){
            String odd = expandcenter(s, i, i);
            String even = expandcenter(s, i, i+1);
            
            if(odd.length() > longestPali.length())
                longestPali = odd;
            if(even.length() > longestPali.length())
                longestPali = even;
        }

        return longestPali;
    }

    String expandcenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
