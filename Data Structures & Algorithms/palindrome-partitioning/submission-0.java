class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, res, new ArrayList<>(), 0);
        return res;
    }

    boolean isPalindrome(String s, int st, int ed){
        while(st<ed){
            if(s.charAt(st) != s.charAt(ed))
                return false;
            st++;
            ed--;
        }
        return true;
    }

    void backtrack(String s, List<List<String>> res, List<String> tmp, int partInd){
        int n = s.length();
        if(partInd == n){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int end=partInd;end<n;end++){
            if(isPalindrome(s, partInd, end)){
                tmp.add(s.substring(partInd, end+1));
                backtrack(s, res, tmp, end+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
