class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        
        int preSmall[] = new int[n];
        int nextSmall[]= new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){

            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }

            if(st.isEmpty()){
                preSmall[i]=0;
            }
            else{
                preSmall[i]=st.peek()+1;
            }
            st.push(i);

        }

        st.clear();

        for(int i=n-1;i>=0;i--){

            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nextSmall[i]=n-1;
            }
            else{
                nextSmall[i]=st.peek()-1;
            }
            st.push(i);

        }


        int maxArea = 0;

        for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea,heights[i]*(nextSmall[i]-preSmall[i]+1));
        }

        return maxArea;
    }
}
