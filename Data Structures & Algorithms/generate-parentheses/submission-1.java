class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        backtrack(n, res, new StringBuilder(), 0, 0);
        return res;
    }


    void backtrack(int n, List<String> res, StringBuilder cur, int open, int close){
        if(open > n || close > n || close > open)
            return;
        
        if(open+close == 2*n){
            res.add(cur.toString());
            return;
        }

        if(open <= n){
        cur.append("(");
        backtrack(n, res, cur, open+1, close);
        cur.deleteCharAt(cur.length()-1);
        }
        if(close < open){
        cur.append(")");
        backtrack(n, res, cur, open, close+1);
        cur.deleteCharAt(cur.length()-1);
        }
    }
}
