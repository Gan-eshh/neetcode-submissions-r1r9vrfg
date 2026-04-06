class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxRect = 0;
        Stack<Integer> st = new Stack<>();
        int n = heights.length;

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int nse = i;
                int curEle = heights[st.pop()];
                int pse = st.isEmpty() ? -1 : st.peek();

                maxRect = Math.max(maxRect, curEle * (nse-pse-1));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = n;
            int curEle = heights[st.pop()];
            int pse = st.isEmpty() ? -1 : st.peek();

            maxRect = Math.max(maxRect, curEle * (nse-pse-1));
        }
        return maxRect;
    }
}
