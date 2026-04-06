class Solution {
    public int[] dailyTemperatures(int[] tem) {
        int n = tem.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && tem[st.peek()] <= tem[i])
                st.pop();
            res[i] = st.isEmpty() ? 0 : st.peek()-i;
            st.push(i);
        }
        return res;
    }
}
