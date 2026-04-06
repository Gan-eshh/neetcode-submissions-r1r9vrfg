class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int res = 1;

        for(String token : tokens){
            if(token.equals("*")){
                int s = st.pop();
                int f = st.pop();
                int ans = s * f;
                st.push(ans);
            }
            else if(token.equals("/")){
                int s = st.pop();
                int f = st.pop();
                int ans = f/s;
                st.push(ans);
            }
            else if(token.equals("+")){
                int s = st.pop();
                int f = st.pop();
                int ans = s + f;
                st.push(ans);
            }
            else if(token.equals("-")){
                int s = st.pop();
                int f = st.pop();
                int ans = f-s;
                st.push(ans);
            }
            else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}
