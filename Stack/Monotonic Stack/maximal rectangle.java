class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)  return 0;
        
        int calcLargestHist[] = new int[matrix[0].length];

        int maxRec=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                
                //if current element is 1 then copy the value of same index of upper row 
                //that will contribute in height of our histogram
                if(matrix[i][j]=='1')
                    calcLargestHist[j]=calcLargestHist[j]+1;
                //if cureent element is 0 then simply put zero
                else
                    calcLargestHist[j]=0;
                
            }
            
            //calculate max area for each new calcLargestHist for each row
            maxRec=Math.max(maxRec,maxHisto(calcLargestHist));
        }
        
        return maxRec;
        
    }
    
    public int maxHisto(int[] hist){
        
        int n = hist.length;
        int leftSmall [] = new int[hist.length];
        int rightSmall[] = new int[hist.length];
        
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0;i<n;i++){
            
            while(!st.isEmpty() && hist[st.peek()]>=hist[i])
                st.pop();
            
            if(st.isEmpty())
                leftSmall[i]=0;
            
            else{
                leftSmall[i]=st.peek()+1;
            }
            
            st.push(i);
        }
        
        while(!st.isEmpty())
            st.pop();
        
        for(int i=n-1;i>=0;i--){
            
            while(!st.isEmpty() && hist[st.peek()]>=hist[i])
                st.pop();
            
            if(st.isEmpty())
                rightSmall[i]=n-1;
            
            else
                rightSmall[i]=st.peek()-1;
            
            st.push(i);
        }
        
        int maxArea=0;
        
        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea,hist[i]*(rightSmall[i]-leftSmall[i]+1));
        }
        
        return maxArea;
    }
}
