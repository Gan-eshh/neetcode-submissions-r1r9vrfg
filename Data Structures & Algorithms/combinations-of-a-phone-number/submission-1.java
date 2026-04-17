class Solution {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length() == 0)
            return res;
        backtrack(digits, res, new StringBuilder(), 0);
        return res;
    }

    void backtrack(String digits, List<String> res, StringBuilder sb, int digitInd){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(digitInd)-'0'];

        for(int letInd = 0;letInd<letters.length();letInd++){
            sb.append(letters.charAt(letInd));
            backtrack(digits, res, sb, digitInd+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
